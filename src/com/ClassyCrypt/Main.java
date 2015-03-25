package com.ClassyCrypt;

import com.ClassyCrypt.Model.*;
import com.ClassyCrypt.Utils.Debug;
import com.ClassyCrypt.Utils.Constant;
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
                                  //Freq  //Count
    public static ArrayList<Diagram> actualFrequencies;

    public static void main(String[] args) {
        Debug.hd(Debug.Type.SYSTEM, "ClassyCrypt ");
        try
        {
            Debug.out(Debug.Type.SYSTEM, "Arg length", args.length);
            if (args.length > 0)
            {
                //Process Command line arguments
                arguments = new Arguments(args);
                fileHandler = new FileHandler(arguments.inputPath);
                cipher = fileHandler.readText();

                performAnalysis();
                outputResults();
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
            actualFrequencies.add(new Diagram((String)entry.getKey(),countMatches(cipher, (String)entry.getKey()))); //Note just getting count not proper frequency calc
        }

        Collections.sort(actualFrequencies,new DiagramComparator());
    }

    private static void outputResults()
    {
        if (arguments.outputToStdOut)
        {

            switch (arguments.analysisType) {
                case DIAGRAM_FREQUENCY:
                    System.out.println("\n--------------------------------");
                    System.out.println("Transposition Cipher Diagram Frequencies");
                    System.out.println("--------------------------------");
                    Integer rank = 1;
                    for (Diagram diagram : actualFrequencies) {
                        System.out.println(diagram.letters+"= "+diagram.count + " Current Frequency Rank= "+rank+" English Rank= "+Constant.DIAGRAM_FREQUENCIES.get(diagram.letters));
                        rank ++;
                    }
                    break;
            }

        }
        else
        {
            //File formattedFile = new File(path + "", lines);
            //FileHandler fileHandler = new FileHandler();
            //fileHandler.file = formattedFile;
            //fileHandler.writeFile();
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
