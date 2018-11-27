package com.lastminute;

import java.util.LinkedHashMap;


public class Main {


    /* main method*/
    public static void main(String args[]){

        // Create manager and variables
        FlightsManager manager = new FlightsManager();

        int passengers;
        int date;
        String origin;
        String destination;
        LinkedHashMap<String, Double> results;

        // 1st example: 1 passenger, 31 days to the departure date, flying AMS -> FRA

        passengers = 1;
        date = 31;
        origin = "AMS";
        destination = "FRA";
        results = manager.getFlightsInfo(origin, destination, date, passengers);
        manager.printResults(passengers,date,origin,destination,results);


       // 2nd example: 3 passengers, 15 days to the departure date, flying LHR -> IST

        passengers = 3;
        date = 15;
        origin = "LHR";
        destination = "IST";
        results = manager.getFlightsInfo(origin, destination, date, passengers);
        manager.printResults(passengers,date,origin,destination,results);


        // 3rd example: 2 passengers, 2 days to the departure date, flying BCN -> MAD

        passengers = 2;
        date = 2;
        origin = "BCN";
        destination = "MAD";
        results = manager.getFlightsInfo(origin, destination, date, passengers);
        manager.printResults(passengers,date,origin,destination,results);


        // 4th example: 2 passengers, 2 days to the departure date, CDG -> FRA

        passengers = 2;
        date = 2;
        origin = "CDG";
        destination = "FRA";
        results = manager.getFlightsInfo(origin, destination, date, passengers);
        manager.printResults(passengers,date,origin,destination,results);


    }


}


