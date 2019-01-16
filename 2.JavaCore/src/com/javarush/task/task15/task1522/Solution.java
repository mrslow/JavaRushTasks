package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planetName;
        try {
            planetName = reader.readLine();
            reader.close();
        } catch (IOException ignored) {
            planetName = "";
        }

        if (Planet.EARTH.equals(planetName)) {
            thePlanet = Earth.getInstance();
        } else if (Planet.MOON.equals(planetName)) {
            thePlanet = Moon.getInstance();
        } else if (Planet.SUN.equals(planetName)) {
            thePlanet = Sun.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
