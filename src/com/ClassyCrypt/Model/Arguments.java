package com.ClassyCrypt.Model;
import com.ClassyCrypt.Utils.Constant;

/**
 * Name:brentparish
 * Created: 24/03/2015
 */
public class Arguments {

    public String inputPath = "";   //ClassyCrypt Source Code file
    public String outputPath = "";  //ClassyCrypt  Output listing
    public Constant.ANALYSIS_TYPE analysisType = Constant.ANALYSIS_TYPE.DIAGRAM_FREQUENCY;
    public boolean outputToStdOut = false;

    public Arguments()
    {

    }

    public Arguments(String[] args)
    {
        this.inputPath = args[0];      //ClassyCrypt Source Code file

        if (args.length > 1)
        {
            this.outputPath = args[1];  //Outputfile

            if (args.length > 2)
            {
                //Analysis To perform
                char[] type = args[2].toUpperCase().toCharArray();
                switch (type[0]) {
                    case 'D':
                        analysisType = Constant.ANALYSIS_TYPE.DIAGRAM_FREQUENCY;
                        break;
                    default:
                        analysisType = Constant.ANALYSIS_TYPE.DIAGRAM_FREQUENCY;
                        break;
                }

            }
        }
        else
        {
            this.outputToStdOut = true;
        }
    }
}
