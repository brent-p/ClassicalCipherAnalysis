package com.ClassyCrypt.Utils;

/**
 * Name:brentparish
 * Created: 24/03/2015
 */
public class Debug {

    public enum Type
    {
        SYSTEM, FREQUENCY
    }
    public static boolean debugOn = false;
    public static boolean systemOn = false;
    public static boolean frequencyOn = false;

    //E.g. Debug.out("X",x);
    public static void out(Type type, Object... strArgs)
    {

        if (!silenceOutput(type))
        {
            boolean label = true;
            for (Object str : strArgs)
            {
                try {
                    String s = String.valueOf(str);
                    if (label) {
                        System.out.print(s + "=[");
                    } else {
                        System.out.print(s + "] ");
                    }
                    label ^= true;
                }catch (Exception e)
                {
                    //move on with life
                }
            }
            System.out.print("\n");
        }
    }

    public static void hd(Type type,String str)
    {
        if (!silenceOutput(type))
        {
            System.out.println("*** "+str+" ***");
        }
    }

    public static void ex(Exception e)
    {
        hd(Type.SYSTEM, "Exception Hit");
        out(Type.SYSTEM, "Error",e.toString());
        e.printStackTrace();
    }

    private static boolean silenceOutput(Type type)
    {
        if (debugOn)
        {
            if (type == Type.SYSTEM && !systemOn) return true;
            if (type == Type.FREQUENCY && !frequencyOn) return true;
            return false;
        }
        else {
            return true;
        }

    }
}
