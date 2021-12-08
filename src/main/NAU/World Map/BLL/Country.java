package BLL;

import static java.util.Arrays.copyOf;

class Country extends Geolocation { // Перевантажити метод toString / Написати Exception на нульовий аргумент
    private City[] cities;

    public Country(String name, int code) {
        super(name, code);
        cities = new City[3];
    }

    void changeCityParameters(String cityName, int cityCode, int residents, boolean isCapital){
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getName().equals(cityName)){
                cities[i].setCode(cityCode);
                cities[i].setResidents(residents);
                cities[i].setCapital(isCapital);
            }
        } // Exception на null
    }

    City searchCity(int cityCode){
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getCode() == cityCode){
                return cities[i];
            }
        }
        return null;
    }

    void addCity(String cityName, int cityCode, int residents, boolean isCapital, String countryMember){
        citiesSpaceChecker();
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] == null){
                cities[i] = new City(cityName, cityCode, residents, isCapital, countryMember);
                return;
            }
        }
    }

    void removeCity(String cityName){
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getName().equals(cityName)){
                cities[i] = null;
                return;
            }
        } // Exception на null
    }

    String getCities(){
        return cities.toString();
    }

    private void citiesSpaceChecker() {
        int spaceCounter = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null){
                spaceCounter++;
            }
        }
        if (spaceCounter == cities.length){
            City[] temp = cities;
            cities = copyOf(temp, temp.length * 2);
        }
    }
}
