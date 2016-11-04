package com.plemel;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner numberScanner = new Scanner(System.in);
    static Scanner stringScanner = new Scanner(System.in);
    static ArrayList<String> lakeNames = new ArrayList<>();
    static ArrayList<Double> times = new ArrayList<>();
    //Specify type in pointy brackets: < TypeOfKey, TypeOfValues>
    static HashMap<String, Double> runningTimes = new HashMap<>();
    //Main Method
    public static void main(String[] args) {

        //initialize an ArrayList
        ArrayList<LakeRuns> lakeRunsArrayList = new ArrayList<>();

        boolean userContinue = true;

        while (userContinue) {

            System.out.println("Enter lake name: ");
            String lakeName = stringScanner.nextLine();

            System.out.println("Enter time: ");
            double time = numberScanner.nextDouble();

            //ArrayList for lakeNames

            lakeNames.add(lakeName);

            //ArrayList for times

            times.add(time);


            if (lakeRunsArrayList.isEmpty()) {

                LakeRuns first = new LakeRuns(lakeName);
                //add time to arrayList property
                first.addRunTime(time);
                //add object to arrayList that contains LakeRuns objects
                lakeRunsArrayList.add(first);
            } else {
                //iterate through a copy of a list to avoid ConcurrentModificationException
                ArrayList<LakeRuns> copy = new ArrayList<>(lakeRunsArrayList);

                boolean inList = false;

                while (!inList) {

                    for (int x = 0; x < copy.size(); x++) {
                        if (Objects.equals(copy.get(x).getName(), lakeName)) {
                            inList = true;

                            lakeRunsArrayList.get(x).addRunTime(time);
                        }
                    }

                    if (!inList) {

                        LakeRuns lake1 = new LakeRuns(lakeName);
                        lake1.addRunTime(time);
                        lakeRunsArrayList.add(lake1);

                        inList = true;
                    }

                    copy.clear();
                }
                //loop through objects
                for (LakeRuns lake : lakeRunsArrayList) {
                    //calls method to calculate the average for each lake
                    //displays data to user using class methods
                    System.out.println("The fastest run time for " + lake.getName() + " was " + lake.getShortest());
                }


                System.out.println("Would you like to make another record (Y or N)");
                String userCont = stringScanner.nextLine();

                if (!userCont.equalsIgnoreCase("y")) {

                    userContinue = false;

                }
            }




        }
        //Method to get best times
        calculateBestTimes(lakeNames, times);
        //Print Best Times
        printBestTimes(runningTimes);
        stringScanner.close();
        numberScanner.close();
    }

    //Method Here
    public static void calculateBestTimes(ArrayList lakes, ArrayList times){



        for (int x = 0; x < lakes.size(); x++) {


            String lake = (String) lakes.get(x);
            String uppercaseLake = lake.toUpperCase();

            Double time = (Double) times.get(x);


            runningTimes.put(uppercaseLake, time);

        }
        for (int x = 0; x < lakes.size(); x++) {
            String lake = (String) lakes.get(x);
            String uppercaseLake = lake.toUpperCase();

            Double time = (Double) times.get(x);
            for (String tempLake : runningTimes.keySet()) {

                //System.out.println("********************Lake: " + tempLake);

                //if (runningTimes.keySet(tempLake) == runningTimes.get(uppercaseLake)

                if (uppercaseLake.equalsIgnoreCase(tempLake)) {
                    //System.out.println("Its doing it");
                    //System.out.println("This is running time: " + runningTimes.get(tempLake));
                    //System.out.println("Time is >>>: " + time);

                    if (runningTimes.get(tempLake) > time){

                        runningTimes.put(uppercaseLake, time);
                    }
                }
            }
        }
    }


    //Print Lakes + Times Method
    public static void printLakesAndTimes(ArrayList lakes, ArrayList times){

        for (int x = 0; x < lakes.size(); x++){

            System.out.println(lakes.get(x) + " , " + times.get(x));

        }

    }


    //Print BestTimes Method
    public static void printBestTimes(HashMap runningTimes){

        System.out.println("Here are your best times for each lake:");

        for (Object lakeName : runningTimes.keySet()){

            System.out.println("Lake: " + lakeName);
            System.out.println("Best Time: " + runningTimes.get(lakeName));
        }

    }
}


