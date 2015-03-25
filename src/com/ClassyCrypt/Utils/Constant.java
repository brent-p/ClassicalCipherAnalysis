package com.ClassyCrypt.Utils;

import com.ClassyCrypt.Model.Diagram;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Name:brentparish
 * Created: 24/03/2015
 */
public class Constant {

    public enum ANALYSIS_TYPE {
        DIAGRAM_FREQUENCY
    }

    public static HashMap<String,Integer> DIAGRAM_FREQUENCIES;

    static
    {
        // The most frequent pairs of letters(diagrams)
        // in English on a relative scale fof 1 to 10
        DIAGRAM_FREQUENCIES = new HashMap<String, Integer>();
        DIAGRAM_FREQUENCIES.put("TH", 1);
        DIAGRAM_FREQUENCIES.put("HE", 2);
        DIAGRAM_FREQUENCIES.put("IN", 3);
        DIAGRAM_FREQUENCIES.put("ER", 4);
        DIAGRAM_FREQUENCIES.put("RE", 5);
        DIAGRAM_FREQUENCIES.put("ON", 6);
        DIAGRAM_FREQUENCIES.put("AN", 7);
        DIAGRAM_FREQUENCIES.put("EN", 8);
        DIAGRAM_FREQUENCIES.put("AT", 9);
        DIAGRAM_FREQUENCIES.put("ES", 10);
        DIAGRAM_FREQUENCIES.put("ED", 11);
        DIAGRAM_FREQUENCIES.put("TE", 12);
        DIAGRAM_FREQUENCIES.put("TI", 13);
        DIAGRAM_FREQUENCIES.put("OR", 14);
        DIAGRAM_FREQUENCIES.put("ST", 15);
        DIAGRAM_FREQUENCIES.put("AR", 16);
        DIAGRAM_FREQUENCIES.put("ND", 17);
        DIAGRAM_FREQUENCIES.put("TO", 18);
        DIAGRAM_FREQUENCIES.put("NT", 19);
        DIAGRAM_FREQUENCIES.put("IS", 20);
        DIAGRAM_FREQUENCIES.put("OF", 21);
        DIAGRAM_FREQUENCIES.put("IT", 22);
        DIAGRAM_FREQUENCIES.put("IT", 23);
        DIAGRAM_FREQUENCIES.put("AS", 24);
    }
}
