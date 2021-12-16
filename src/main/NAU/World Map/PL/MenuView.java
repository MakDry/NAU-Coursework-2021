package PL;

public class MenuView {

    static final String ENTER_NAME = ">Enter name: ";
    static final String ENTER_CODE = ">Enter code: ";
    static final String ENTER_CAPITAL = ">Is this the capital? (yes/no): ";
    static final String ENTER_RESIDENTS = ">How many residents live here: ";
    static final String ENTER_COUNTRY_MEMBER = ">This city is member of: ";
    
    void inputData(String dataName){
        System.out.println(">Enter " + dataName + ": ");
    }
}
