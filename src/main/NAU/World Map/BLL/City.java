package BLL;

class City extends Geolocation{
    private int residents;
    private boolean isCapital;
    private String countryMember;

    public City(String name, int code, int residents, boolean isCapital, String countryMember) {
        super(name, code);
        this.residents = residents;
        this.isCapital = isCapital;
        this.countryMember = countryMember;
    }

}
