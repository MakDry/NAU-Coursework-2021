package BLL;

import static java.util.Arrays.copyOf;

public class World { // Написати Exception на нульовий аргумент
    private Country[] countries;

    public World() {
        countries = new Country[10];
    }

    public String findAllCitiesInCountry(int countryCode) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getCode() == countryCode) {
                return countries[i].getCities();
            }
        }
        return null; // Exception на null
    }

    public void changeCityParameters(String countryName, String cityName, int cityCode, int residents, boolean isCapital) {
        String newCountryName = firstUpperCase(countryName);
        String newCityName = firstUpperCase(cityName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                countries[i].changeCityParameters(newCityName, cityCode, residents, isCapital);
                return;
            }
        } // Exception на null
    }

    public void changeCountryParameters(String countryName, String newUserCountryName, int countryCode) {
        String newCountryName = firstUpperCase(countryName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                countries[i].setName(newUserCountryName);
                countries[i].setCode(countryCode);
                return;
            }
        } // Exception на null
    }

    public City searchCityInCountry(String countryName, int cityCode) { // Можна переробити так, щоб на вхід подавати тільки код
        String newCountryName = firstUpperCase(countryName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                return countries[i].searchCity(cityCode);
            }
        }
        return null; // Exception на null
    }

    public Country searchCountry(int countryCode) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getCode() == countryCode) {
                return countries[i];
            }
        }
        return null; // Exception на null
    }

    public void removeCountry(String countryName) {
        String newCountryName = firstUpperCase(countryName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                countries[i] = null;
            }
        } // Exception на null
    }

    public void addCountry(String countryName, int countryCode) {
        String newCountryName = firstUpperCase(countryName);
        countriesSpaceChecker();
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null) {
                countries[i] = new Country(newCountryName, countryCode);
                return;
            }
        }
    }

    public void removeCityFromCountry(String countryName, String cityName) {
        String newCountryName = firstUpperCase(countryName);
        String newCityName = firstUpperCase(cityName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                countries[i].removeCity(newCityName);
                return;
            }
        }
    }

    public void addCityToCountry(String countryName, String cityName, int cityCode, int residents, boolean isCapital) {
        String newCountryName = firstUpperCase(countryName);
        String newCityName = firstUpperCase(cityName);
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(newCountryName)) {
                countries[i].addCity(newCityName, cityCode, residents, isCapital, newCountryName);
                return;
            }
        }
    }

    public String[] getAllCities() {
        int countryCounter = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                countryCounter++;
            }
        }
        String[] cities = new String[countryCounter];
        for (int i = 0; i < countries.length; i++) {
            cities[i] = countries[i].getCities();
        }
        return cities;
    }

    private void countriesSpaceChecker() {
        int spaceCounter = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                spaceCounter++;
            }
        }
        if (spaceCounter == countries.length) {
            Country[] temp = countries;
            countries = copyOf(temp, temp.length * 2);
        }
    }

    private static String firstUpperCase(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }
}