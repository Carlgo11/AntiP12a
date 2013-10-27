package org.carlgo11.anti.p12a;

import java.util.Random;

public class RandomString {

    public static String string = "";
    static String easy = "0123456789";
    static String normal = "0123456789abcdefghijklmnopqrstuvwxyz";
    static String hard = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String diff;
    static antip12a r;

    public static void getDifficulty()
    {
        String m = r.Difficulty;

        if (m.equalsIgnoreCase("Hard"))
        {
            diff = hard;
        }
        else if (m.equalsIgnoreCase("Normal"))
        {
            diff = normal;
        }
        else if (m.equalsIgnoreCase("Easy"))
        {
            diff = easy;
        }
    }
    public static void random()
    {
        getDifficulty();
        Random n = new Random();

        for(int i = 0; i < 10; i++)
        {
            int num = n.nextInt(diff.length());
            String s = "" + diff.charAt(num);
            string += s;
        }

    }
}
