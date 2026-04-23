package com.pluralsight;
import java.io.*;
import java.util.*;

public class AdventureTime
{
    static ArrayList<Step> adventureSteps =  loadAdventure();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        //test stuff
        ArrayList<Step> adventureSteps = loadAdventure();

        Step step1 = adventureSteps.get(0);

        System.out.println(step1.getStoryText());
        //end of test stuff

        homeScreen();


    }
    public static Step findStep(int ID)
    {
        for (int i = 0; i < adventureSteps.size(); i++)
        {
            Step currentStep = adventureSteps.get(i);
            if(currentStep.getID() == ID)
            {
                return currentStep;
            }
        }
        return null; //shouldnt happen w/ valid ID # as of right now
    }

    public static void gameScreen(int ID)
    {
        Step currentStep = findStep(ID);

        if(currentStep == null)
        {
            System.out.println("\n An error occurred. The next scene was not found.");
        }

        else
        {
            System.out.println(currentStep.getStoryText() + "\n");
            System.out.println("Select an option. Enter 1 or 2: ");
            System.out.println("\n1) " + currentStep.getOption1Text());
            System.out.println("2) " + currentStep.getOption2Text() + "\n");
        }

    }


    public static void homeScreen()
    {
        System.out.println("""
                Welcome to Adventure Time.
                --------------------------
                Enter 1 or 2.
                
                1) Play game!
                2) Exit\n""");

        String playerChoice = input.nextLine();

        switch(playerChoice)
        {
            case "1":
                gameScreen(1);

            case "2":
                System.exit(0);

            default:
                System.out.println("PLEASE ENTER 1 OR 2!!! PLEASE!!!");
                homeScreen();

        }

    }


    public static ArrayList<Step> loadAdventure()
    {
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            ArrayList<Step> steps = new ArrayList<>();

            while (line != null)
            {
                //System.out.println(line);
                //line = bufferedReader.readLine();

                String[] columns = line.split("\\|");


                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns[2];
                int option1NextID = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextID = Integer.parseInt(columns[5]);

                Step step = new Step(id, storyText, option1Text, option2Text, option1NextID, option2NextID);

                steps.add(step);
                line = bufferedReader.readLine();

            }

            fileReader.close();
            bufferedReader.close();
            return steps;
        }
        catch (Exception ex)
        {
            System.out.println("Essential game files not found. Exiting program.");
            ex.printStackTrace();
            System.exit(0);
            return null;
        }


    }
}