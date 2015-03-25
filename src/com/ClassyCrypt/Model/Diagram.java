package com.ClassyCrypt.Model;

/**
 * Name:brentparish
 * Student No: c3109455
 * Created: 24/03/2015.
 */
public class Diagram {
    public String letters = "";
    public Integer frequencyRank = 0;
    public Integer count = 0;

    public Diagram()
    {

    }

    public Diagram(String diagram, Integer count)
    {
        this.letters = diagram;
        this.count = count;
    }
}
