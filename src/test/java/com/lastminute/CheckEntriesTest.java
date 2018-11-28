package com.lastminute;

import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CheckEntriesTest {


    private final FlightsManager manager = new FlightsManager();


    // 1 passenger, 31 days to the departure date, flying AMS -> FRA
    @Test
    public void checkResults1(){
        String price;
        int passengers = 1;
        int date = 31;
        String origin = "AMS";
        String destination = "FRA";

        LinkedHashMap<String, Float> result = manager.getFlightsInfo(origin, destination, date, passengers);

        // check codes
        assertTrue(String.valueOf(result.containsKey("TK2372")), true);
        assertTrue(String.valueOf(result.containsKey("TK2659")), true);
        assertTrue(String.valueOf(result.containsKey("LH5909")), true);

        //check prices
        price = result.get("TK2372").toString();
        assertEquals("157.6", price);

        price = result.get("TK2659").toString();
        assertEquals("198.4", price);

        price = result.get("LH5909").toString();
        assertEquals("90.4", price);
    }


    //3 passengers, 15 days to the departure date, flying LHR -> IST
    @Test
    public void checkResults2(){

        int passengers = 3;
        int date = 15;
        String origin = "LHR";
        String destination = "IST";
        String price;

        LinkedHashMap<String, Float> result = manager.getFlightsInfo(origin, destination, date, passengers);

        // check codes
        assertTrue(String.valueOf(result.containsKey("TK8891")), true);
        assertTrue(String.valueOf(result.containsKey("LH1085")), true);

        //check prices
        price = result.get("TK8891").toString();
        assertEquals("900.0", price);

        price = result.get("LH1085").toString();
        assertEquals("532.8", price);
    }


    //2 passengers, 2 days to the departure date, flying BCN -> MAD
    @Test
    public void checkResults3(){

        int passengers = 2;
        int date = 2;
        String origin = "BCN";
        String destination = "MAD";
        String price;

        LinkedHashMap<String, Float> result = manager.getFlightsInfo(origin, destination, date, passengers);

        // check codes
        assertTrue(String.valueOf(result.containsKey("IB2171")), true);
        assertTrue(String.valueOf(result.containsKey("LH5496")), true);

        //check prices
        price = result.get("IB2171").toString();
        assertEquals("777.0", price);

        price = result.get("LH5496").toString();
        assertEquals("879.0", price);
    }


    //2 passengers, 2 days to the departure date, flying CDG -> FRA
    @Test
    public void checkResults4(){

        int passengers = 2;
        int date = 2;
        String origin = "CDG";
        String destination = "FRA";

        LinkedHashMap<String, Float> result = manager.getFlightsInfo(origin, destination, date, passengers);

        // check codes
        assertTrue(String.valueOf(result.isEmpty()), true);
    }
}
