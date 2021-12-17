package BLL;

public class City extends Geolocation {
    private int residents;
    private boolean isCapital;
    private String countryMember;

    public City(String name, int code, int residents, boolean isCapital, String countryMember) { // Оптимізувати метод toString
        super(name, code);
        this.residents = residents;
        this.isCapital = isCapital;
        this.countryMember = countryMember;
    }

    public City(){
        super(null, 0);
        residents = 0;
        isCapital = false;
        countryMember = null;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public boolean getCapital() {
        return isCapital;
    }

    public void setCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }

    public String getCountryMember() {
        return countryMember;
    }

    public void setCountryMember(String country) {
        this.countryMember = country;
    }

    @Override
    public String toString() {
        return "\nCity data:" +
                "\n1. City name: " + getName() +
                "\n2. Unique code: " + getCode() +
                "\n3. Number of residents: " + getResidents() +
                "\n4. Capital status: " + getCapital();
    }
}
