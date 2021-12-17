package BLL;

import static java.util.Arrays.copyOf;

public class World {
    private Country[] countries;

    public World() {
        countries = new Country[10];
    }

    public City[] findAllCitiesInCountry(int countryCode) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (countries[i].getCode() == countryCode) {
                    return countries[i].getCities();
                }
            }
        }
        return null;
    }

    public void changeCityParameters(String countryName, String cityName, int cityCode, int residents, boolean isCapital) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(countryName)) {
                countries[i].changeCityParameters(cityName, cityCode, residents, isCapital);
                return;
            }
        }
    }

    public void changeCountryParameters(String countryName, String newUserCountryName, int newUserCountryCode) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(countryName)) {
                countries[i].setName(newUserCountryName);
                countries[i].setCode(newUserCountryCode);
                for (int j = 0; j < countries[i].getCities().length; j++) {
                    if (countries[i].getCities()[j] != null) {
                        countries[i].getCities()[j].setCountryMember(newUserCountryName);
                    }
                }
                return;
            }
        }
    }

    public String searchObjectByCode(int code) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (countries[i].getCode() == code) {
                    return countries[i].toString();
                }
                for (int j = 0; j < countries[i].getCities().length; j++) {
                    if (countries[i].getCities()[j] != null) {
                        if (countries[i].getCities()[j].getCode() == code) {
                            return countries[i].getCities()[j].toString();
                        }
                    }
                }
            }
        }
        return null;
    }

    public void removeCountry(String countryName) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (countries[i].getName().equals(countryName)) {
                    countries[i] = null;
                }
            }
        }
    }

    public void addCountry(String countryName, int countryCode) {
        countriesSpaceChecker();
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == null) {
                countries[i] = new Country(countryName, countryCode);
                return;
            }
        }
    }

    public void removeCityFromCountry(String countryName, String cityName) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (countries[i].getName().equals(countryName)) {
                    countries[i].removeCity(cityName);
                    return;
                }
            }
        }
    }

    public void addCityToCountry(String countryName, String cityName, int cityCode, int residents, boolean isCapital) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(countryName)) {
                countries[i].addCity(cityName, cityCode, residents, isCapital, countryName);
                return;
            }
        }
    }

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public boolean idController(int code) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (countries[i].getCode() == code) {
                    return false;
                }
                for (int j = 0; j < countries[i].getCities().length; j++) {
                    if (countries[i].getCities()[j] != null) {
                        if (countries[i].getCities()[j].getCode() == code) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean nameController(String name) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                if (name.equals(countries[i].getName())) {
                    return false;
                }
                for (int j = 0; j < countries[i].getCities().length; j++) {
                    if (countries[i].getCities()[j] != null) {
                        if (name.equals(countries[i].getCities()[j].getName())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
}