package com.lastminute;

import java.util.HashMap;
import java.util.List;


public class Factory {


    private HashMap<String, Integer> prices ;
    private List<List<String>> routes;


    public Factory(){

        this.prices = readPrices();
        this.routes = readRoutes();
    }


    /* Get prices*/
    private HashMap<String, Integer> readPrices(){

        List<List<String>> list = CsvFiles.readAllRecords(fullPathTo("flight-prices.csv"));
        HashMap<String, Integer> prices = new HashMap<String, Integer>();

        for( List<String> row : list){
            /*Save prices with key(code). value(price) format*/
            prices.put(row.get(0), Integer.parseInt(row.get(1)));
        }
        return prices;
    }


    /*Get routes*/
    private List<List<String>> readRoutes(){

        List<List<String>> routes = CsvFiles.readAllRecords(fullPathTo("flight-routes.csv"));
        return routes;
    }


    /*Getter method for a price*/
    public int getPrice(String code){
        if(prices.containsKey(code)){
            return prices.get(code);
        }
        else{
            return 0;
        }
    }


    /*Getter method for routes*/
    public List<List<String>> getRoutes(){

        return this.routes;
    }


    private String fullPathTo(String fileName){

        return getClass().getClassLoader().getResource(fileName).getPath();
    }
}
