package BLL;

abstract class Geolocation {
    private String name;
    private int code;

    protected Geolocation(String name, int code) {
        this.name = name;
        this.code = code;
    }

    protected Geolocation(){
        this.name = "Default";
        this.code = 0;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCode(int code){
        this.code = code;
    }

    public String getName(){
        return this.name;
    }

    public int getCode(){
        return this.code;
    }
}
