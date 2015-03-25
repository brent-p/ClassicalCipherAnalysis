package com.ClassyCrypt;

import com.ClassyCrypt.Model.*;
import com.ClassyCrypt.Utils.Debug;
import com.ClassyCrypt.Utils.Constant;
import com.ClassyCrypt.Utils.File;
import com.ClassyCrypt.Utils.FileHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Name:brentparish
 * Created: 2/08/2014.
 */
//ClassyCrypt
public class Main {

    public static Arguments arguments;
    public static FileHandler fileHandler;
    public static String    cipher;
    public static ArrayList<Diagram> actualFrequencies;

    public static void main(String[] args) {
        Debug.hd(Debug.Type.SYSTEM, "ClassyCrypt ");
        try
        {
            Debug.out(Debug.Type.SYSTEM, "Arg length", args.length);
            if (args.length > 0)
            {

                arguments = new Arguments(args);                    //Process Command line arguments
                fileHandler = new FileHandler(arguments.inputPath); //Open file for reading
                cipher = fileHandler.readText();                    //Read Entire file

                performAnalysis();                                  //Analyse Cipher based on Analysis Type command line argument
                outputResults();                                    //Output results to either stdout or specified file in command line argument
            }
            else
            {
                System.out.println("No input path has been specified. Terminating ClassyCrypt .");
            }
        }
        catch (Exception e)
        {

            Debug.ex(e);
        }
    }

    private static void performAnalysis()
    {
        switch (arguments.analysisType)
        {
            case DIAGRAM_FREQUENCY:
                processDiagramFrequency();
                break;

        }
    }

    private static void processDiagramFrequency()
    {
        Debug.hd(Debug.Type.FREQUENCY,"processDiagramFrequency");
        actualFrequencies = new ArrayList<Diagram>();
        cipher = cipher.replace(" ",""); //Strip Spaces
        cipher = cipher.toUpperCase(); //Convert to uppercase
        Debug.out(Debug.Type.FREQUENCY,"Cipher",cipher);
        for (Map.Entry entry : Constant.DIAGRAM_FREQUENCIES.entrySet())
        {
            actualFrequencies.add(new Diagram((String)entry.getKey(),countMatches(cipher, (String)entry.getKey()))); //Note just getting count not proper frequency calc atm
        }

        Collections.sort(actualFrequencies,new DiagramComparator()); //Sorts high to low
    }

    private static void outputResults()
    {
        ArrayList<String> lines = new ArrayList<String>();
        switch (arguments.analysisType) {
            case DIAGRAM_FREQUENCY:
                lines.add("");
                lines.add("--------------------------------");
                lines.add("Diagram Frequencies");
                lines.add("--------------------------------");


                Integer rank = 1;
                for (Diagram diagram : actualFrequencies) {
                    lines.add((diagram.letters+"= "+diagram.count + " Current Frequency Rank= "+rank+" English Rank= "+Constant.DIAGRAM_FREQUENCIES.get(diagram.letters)));
                    rank ++;
                }
                break;
        }

        if (arguments.outputToStdOut)
        {
            //Write results to StdOut
            for (String line : lines)
            {
                System.out.print(line+"\n");
            }

        }
        else
        {
            //Write results to outputfile
            File formattedFile = new File(arguments.outputPath, lines);
            FileHandler fileHandler = new FileHandler();
            fileHandler.file = formattedFile;
            fileHandler.writeFile();
        }
    }


    public static int countMatches(String str, String sub) {
        if (str.isEmpty() || sub.isEmpty()) {
            return 0;
        }
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

} //end main
