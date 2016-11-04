package com.plemel;
import java.util.ArrayList;

/**
 * Created by Jennifer Plemel on 11/4/2016.
 *
 * * Start with the lakes running program from Lab 4, Essentials Problem 4.
 * Modify this program to use objects to store the data.
 * What class(es) will you create?
 * Your classes and objects should improve your program's organization,
 * conciseness, clarity and structure.
 */


public class LakeRuns {

    private String name;
    private ArrayList<Double> runTimes;

    LakeRuns(String name){
        this.name=name;
        this.runTimes= new ArrayList<Double>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getRunTimes() {
        return this.runTimes;
    }

    public void setRunTimes(ArrayList<Double> runTimes) {
        this.runTimes = runTimes;
    }
    public void addRunTime(double runTime){
        this.runTimes.add(runTime);
    }
    public double getShortest(){
        double shortest = this.runTimes.get(0);
        for (int x=1; x< this.runTimes.size(); x++)
        {
            if (shortest>this.runTimes.get(x)){
                shortest= this.runTimes.get(x);
            }
        }
        return shortest;
    }
    public double getAverageTime(){
        double average = 0;
        double timeTotal=0;
        for( double time :this.runTimes){
            timeTotal+=time;
        }
        average = timeTotal/this.runTimes.size();
        return average;
    }


}
