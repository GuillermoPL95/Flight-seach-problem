package com.lastminute;

import java.util.*;
import java.util.stream.Collectors;


public class FlightsManager {


    private Factory factory;


    public FlightsManager(){

        factory = new Factory();
    }


    /*Method to get the flights information */
    public LinkedHashMap<String, Double> getFlightsInfo(String origin, String destination, int date, int passengers){

        LinkedHashMap<String, Double> results = new LinkedHashMap<String, Double>();

        // Get list of available flights
        List<String> codes = getFlightCodes(origin, destination, factory.getRoutes());

        if(!codes.isEmpty()){
            for(String code : codes){
                int basePrice = factory.getPrice(code);
                Double finalPrice = getFinalPrice(basePrice, date, passengers);
                results.put(code, finalPrice);
            }
        }
        return results;
    }


    //Method to print the results
    public void printResults(int passengers, int date, String origin, String destination, LinkedHashMap<String, Double> results){

        if(passengers > 1){
            System.out.println(String.format("%d passengers, %d days to departure date, flying %s -> %s", passengers, date, origin, destination));

        }else{
            System.out.println(String.format("1 passenger, %d days to departure date, flying %s -> %s", date, origin, destination));
        }

        System.out.println("\n");

        // Print the results of the search
        if(!results.isEmpty()){

            System.out.println("flights:\n");
            for(String code : results.keySet()){

                float finalValue = results.get(code).floatValue();

                if(passengers > 1){

                    int[] values = getBasePriceAndPercentage(finalValue, passengers, date);
                    System.out.println(" * " + code + ", " + finalValue + " € (" + passengers + " * (" + values[0] + "% of " + values[1] + ")");
                }else{
                    System.out.println(" * " + code + ", " + finalValue + " € ");
                }
            }
            System.out.println("\n");
        }
        else{
            System.out.println("no flights available");
        }
        System.out.println("\n");
    }


    /*Method to filter the available flights and get the flight codes*/
    private List<String> getFlightCodes(String origin, String destination, List<List<String>> routes){

        List<String> codes = routes.stream()
                .filter(line -> line.get(0).equals(origin) && line.get(1).equals(destination))
                .map(line -> line.get(2))
                .collect(Collectors.toList());

        return codes;
    }


    /*Method to obtain final price */
    private double getFinalPrice(int basePrice, int date, int passengers){

        double finalPrice;

        if (date > 30){
            finalPrice = basePrice * 0.80;
        }
        else if (15 < date){
            finalPrice = basePrice;
        }
        else if (3 < date){
            finalPrice = basePrice * 1.20;
        }
        else{
            finalPrice = basePrice * 1.50;
        }
        return finalPrice * passengers ;
    }


    /*Method to obtain base price and percentaje*/
    private int[] getBasePriceAndPercentage(double finalPrice, int passengers, int date){

        double percentage;
        double basePrice;
        int[] result = new int[2];

        if (date > 30){
            percentage = 0.80;
        }
        else if (15 < date){
            percentage = 1;
        }
        else if (3 < date){
            percentage = 1.20;
        }
        else{
            percentage = 1.50;
        }

        basePrice = (finalPrice / 3)/percentage;
        result[0] = (int)(percentage * 100);
        result[1] = (int)basePrice;

        return result;
    }

}
