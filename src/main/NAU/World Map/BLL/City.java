package BLL;

class City extends Geolocation {
    private int residents;
    private boolean isCapital;
    private String countryMember;

    public City(String name, int code, int residents, boolean isCapital, String countryMember) { // Оптимізувати метод toString
        super(name, code);
        this.residents = residents;
        this.isCapital = isCapital;
        this.countryMember = countryMember;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }

    public String getCountryMember() {
        return countryMember;
    }

    @Override
    public String toString() {
        return "City{" +
                ", cityName=" + getName() +
                ", code=" + getCode() +
                "residents=" + residents +
                ", isCapital=" + isCapital + '\'' +
                '}';
    }
}
