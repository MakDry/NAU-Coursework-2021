package PL;

public class MenuView {

    public static final String ENTER_NAME = ">Enter name: ";
    public static final String ENTER_CODE = ">Enter code: ";
    public static final String START_MENU = "\t--==Welcome to program==--\n>Choose one of the next options\n" +
            "1. Add new data\n" +
            "2. Read the data\n" +
            "3. Change data parameters";
    public static final String READ_DATA_MENU = ">Choose one of the next options\\n\" +\n" +
            "1. Find a country/city by a unique identifier\n" +
            "2. View a list of countries\n" +
            "3. View a list of cities in the country by code";
    public static final String CHANGE_DATA_MENU = ">Choose one of the next options\n" +
            "1. Add new country\n" +
            "2. Add new city to country\n" +
            "3. Delete country\n" +
            "4. Delete city from country\n" +
            "5. Change country parameters\n" +
            "6. Change city parameters";
    public static final String ENTER_CAPITAL = ">Is this the capital (yes/no): ";
    public static final String ENTER_RESIDENTS = ">How many residents live here: ";
    public static final String WRONG_INPUT_DATA = "Wrong value!";
    public static final String WRONG_CODE = "Any object with this code does not exist!";
    public static final String SERIALIZER_STATUS = "<Your data was successfully serialized>";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
