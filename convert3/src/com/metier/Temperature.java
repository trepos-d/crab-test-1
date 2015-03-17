You see me trolling, you hatting !!
//test remontée modification 
package com.metier;

public class Temperature {
	/**
     * La valeur, exprimï¿½e en degrï¿½s Celsius
     */
    private double celsius;

    /**
     * Le constructeur, prend des Celsius en paramï¿½tres
    */
    public Temperature(double valeurCelsius)
    {
          celsius = valeurCelsius;
    }

    /**
     * Pour obtenir la valeur en Celsius
     *
     * @return Valeur de la tempï¿½rature en Celsius
   */
    public double getCelsius() {
          return celsius;
    }

    /**
     * Pour obtenir la valeur en Fahrenheit
     *
     * @return Valeur de la tempï¿½rature en Farenheit
    */
    public double getFahrenheit() {
          return (celsius * 9/5) + 32;
  }



}
