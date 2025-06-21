package org.example;

public class UnitConverterLogic {

    public static String[] getUnitsForCategory(String category) {
        switch (category) {
            case "Length":
                return new String[]{"Kilometers", "Miles"};
            case "Temperature":
                return new String[]{"Celsius", "Fahrenheit", "Kelvin"};
            default:
                return new String[]{};
        }
    }

    public static double convert(String category, String from, String to, double value) {
        if (category.equals("Length")) {
            if (from.equals("Kilometers") && to.equals("Miles")) return value * 0.621371;
            if (from.equals("Miles") && to.equals("Kilometers")) return value / 0.621371;
        } else if (category.equals("Temperature")) {
            if (from.equals("Celsius") && to.equals("Fahrenheit")) return (value * 9 / 5) + 32;
            if (from.equals("Fahrenheit") && to.equals("Celsius")) return (value - 32) * 5 / 9;
            if (from.equals("Celsius") && to.equals("Kelvin")) return (value + 273.15);
            if (from.equals("Fahrenheit") && to.equals("Kelvin")) return (1.8 * (value-273) + 32);
            if (from.equals("Kelvin") && to.equals("Fahrenheit")) return ((value - 32) * 5/9 + 273.15);
            if (from.equals("Kelvin") && to.equals("Celsius")) return (value - 273.15);
        }
        return value;
    }
}
