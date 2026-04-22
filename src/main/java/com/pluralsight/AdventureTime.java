package com.pluralsight;
import java.io.*;
import java.util.*;

public class AdventureTime
{
    public static void main(String[] args)
    {
        loadAdventure();
    }

    public static void loadAdventure()
    {
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null)
            {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            fileReader.close();
        }
        catch (Exception e)
        {

        }
    }
}