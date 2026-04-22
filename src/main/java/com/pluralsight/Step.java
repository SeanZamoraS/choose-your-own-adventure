package com.pluralsight;

public class Step
{
    private int id;
    private String storyText;
    private String option1Text;
    private String option2Text;
    private int option1NextID;
    private int option2NextID;

    public Step(int id, String storyText, String option1Text, String option2Text,
                int option1NextID, int option2NextID)
    {
        this.id = id;
        this.storyText = storyText;
        this.option1Text = option1Text;
        this.option2Text = option2Text;
        this.option1NextID = option1NextID;
        this.option2NextID = option2NextID;
    }
    //getters
    public int getID() {return this.id;}
    public String getStoryText() {return this.storyText;}
    public String getOption1Text() {return this.option1Text;}
    public String getOption2Text() {return this.option2Text;}
    public int getOption1NextID() {return this.option1NextID;}
    public int getOption2NextID() {return this.option2NextID;}

    //setters
    public void setID(int id) {this.id = id;}
    public void setStoryText(String storyText) {this.storyText = storyText;}
    public void setOption1Text(String option1Text) {this.option1Text = option1Text;}
    public void setOption2Text(String option2Text) {this.option2Text = option2Text;}
    public void setOption1NextID(int option1NextID) {this.option1NextID = option1NextID;}
    public void setOption2NextID(int option2NextID) {this.option2NextID = option2NextID;}
}