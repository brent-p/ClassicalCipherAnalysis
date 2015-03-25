package com.ClassyCrypt;

import com.ClassyCrypt.Model.Diagram;

import java.util.Comparator;

/**
 * Name:brentparish
 * Student No: c3109455
 * Created: 24/03/2015.
 */
public class DiagramComparator implements Comparator<Diagram> {

    @Override
    public int compare(Diagram diagram1, Diagram diagram2) {
        //Sorts from high to low
        return diagram2.count.compareTo(diagram1.count);
    }
}
