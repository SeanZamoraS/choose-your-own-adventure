package com.pluralsight;
import java.io.*;
import java.util.*;

public class AdventureTime
{
    static ArrayList<Step> adventureSteps;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        //test stuff
        //ArrayList<Step> adventureSteps = loadAdventure();

        //Step step1 = adventureSteps.get(0);

        //System.out.println(step1.getStoryText());
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
    //recursion here is a lot easier, no loop just use gameScreen(currentStep.getNextOption1/2ID)
    //stop game if the next id is -1
    {
        //Step currentStep = findStep(ID);
        int nextID = ID;

        while(nextID != -1)
        {
            Step currentStep = findStep(nextID);

            if (currentStep == null)
            {
                System.out.println("\n An error occurred. The next scene was not found.");
            }
            else
            {
                System.out.println(currentStep.getStoryText() + "\n");
                System.out.println("Select an option. Enter 1 or 2: ");
                System.out.println("\n1) " + currentStep.getOption1Text());
                System.out.println("2) " + currentStep.getOption2Text() + "\n");

                String userInput = input.nextLine().strip().toLowerCase();

                switch (userInput) {
                    case "1":
                        //System.out.println(currentStep.getOption1NextID());
                        nextID = currentStep.getOption1NextID();
                        break;

                    case "2":
                        //System.out.println(currentStep.getOption2NextID());
                        nextID = currentStep.getOption2NextID();
                        break;

                    default:
                        System.exit(0);
                        //temporary
                }
            }
        }



    }


    public static void homeScreen()
    {
        System.out.println("""
                Welcome to Adventure Time.
                --------------------------
                Enter 1, 2, or 3.
                
                1) Play "Dark Forest"
                2) Play "The Haunted Castle"
                2) Exit\n""");

        String playerChoice = input.nextLine();

        switch(playerChoice)
        {
            case "1":
                adventureSteps = loadAdventure("adventure1.csv");
                gameScreen(1);

            case "2":
                adventureSteps = loadAdventure("GIVE ME THE FILE GREGOR");
                gameScreen(1);

            case "3":
                System.exit(0);

            default:
                System.out.println("PLEASE ENTER 1 OR 2!!! PLEASE!!! OR 3.....");
                homeScreen();

        }

    }


    public static ArrayList<Step> loadAdventure(String adventureFile)
    {
        try
        {
            FileReader fileReader = new FileReader(adventureFile);
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