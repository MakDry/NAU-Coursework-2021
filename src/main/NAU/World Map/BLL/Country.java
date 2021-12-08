package BLL;

import static java.util.Arrays.copyOf;

class Country extends Geolocation{
    private City[] cities;

    public Country(String name, int code) {
        super(name, code);
        cities = new City[3];
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

    void removeCity(){

    }

    City[] getCities(){
        return cities;
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
