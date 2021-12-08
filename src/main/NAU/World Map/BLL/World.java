package BLL;

import static java.util.Arrays.copyOf;

public class World {
    private Country[] countries;

    public World(){
        countries = new Country[10];
    }

    public void addCountry(String countryName, int countryCode){
        countriesSpaceChecker();
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null){
                countries[i] = new Country(countryName, countryCode);
                return;
            }
        }
    }

    private void countriesSpaceChecker() {
        int spaceCounter = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null){
                spaceCounter++;
            }
        }
        if (spaceCounter == countries.length){
            Country[] temp = countries;
            countries = copyOf(temp, temp.length * 2);
        }
    }
}
