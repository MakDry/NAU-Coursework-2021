package BLL;

import static java.util.Arrays.copyOf;

public class Country extends Geolocation { // Написати Exception на нульовий аргумент / Оптимізувати метод toString
    private City[] cities;

    public Country(String name, int code) {
        super(name, code);
        cities = new City[3];
    }

    public Country() {
        super(null, 0);
        cities = new City[3];
    }

    void changeCityParameters(String cityName, int cityCode, int residents, boolean isCapital) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null) {
                if (cities[i].getName().equals(cityName)) {
                    cities[i].setCode(cityCode);
                    cities[i].setResidents(residents);
                    cities[i].setCapital(isCapital);
                }
            }
        }
    }

    void addCity(String cityName, int cityCode, int residents, boolean isCapital, String countryMember) {
        citiesSpaceChecker();
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] == null) {
                cities[i] = new City(cityName, cityCode, residents, isCapital, countryMember);
                return;
            }
        }
    }

    void removeCity(String cityName) {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getName().equals(cityName)) {
                cities[i] = null;
                return;
            }
        } // Exception на null
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    private void citiesSpaceChecker() {
        int spaceCounter = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null) {
                spaceCounter++;
            }
        }
        if (spaceCounter == cities.length) {
            City[] temp = cities;
            cities = copyOf(temp, temp.length * 2);
        }
    }

    @Override
    public String toString() {
        return "\nCountry data: " +
                "\n1. Country name: " + getName() +
                "\n2. Unique code: " + getCode();
    }
}
