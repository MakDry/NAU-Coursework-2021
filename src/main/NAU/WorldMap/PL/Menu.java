package PL;

import BLL.World;
import DAL.XMLSerializer;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private final World world;
    private final MenuView view;
    private final Scanner input;
    private final Logger logger;

    public Menu(World world, MenuView view) {
        this.world = world;
        this.view = view;
        input = new Scanner(System.in);
        logger = Logger.getLogger(Menu.class.getName());
    }

    void menuController() {
        view.printMessage(MenuView.START_MENU);
        int option = checkOption();

        switch (option) {
            case 1: {
                newCountryProcessor(world);
                newCityProcessor(world);
                XMLSerializer.serializeToXML(world);
                view.printMessage(MenuView.SERIALIZER_STATUS);
                break;
            }
            case 2: {
                World newWorld = XMLSerializer.deserializeFromXML();
                readDataProcessor(newWorld);
                break;
            }
            case 3: {
                World newWorld = XMLSerializer.deserializeFromXML();
                changeDataProcessor(newWorld);
                XMLSerializer.serializeToXML(newWorld);
                view.printMessage(MenuView.SERIALIZER_STATUS);
                break;
            }
        }
    }

    private void changeDataProcessor(World newWorld) {
        view.printMessage(MenuView.CHANGE_DATA_MENU);
        int option = checkChangeMenuOption();

        switch (option) {
            case 1: {
                newCountryProcessor(newWorld);
                break;
            }
            case 2: {
                newCityProcessor(newWorld);
                break;
            }
            case 3: {
                view.printMessage(MenuView.ENTER_NAME);
                String countryName = existedNameChecker(newWorld);
                newWorld.removeCountry(countryName);
                break;
            }
            case 4: {
                System.out.println(">Enter the country name: ");
                String countryName = existedNameChecker(newWorld);
                System.out.println(">Enter the city name");
                String cityName = existedNameChecker(newWorld);
                newWorld.removeCityFromCountry(countryName, cityName);
                break;
            }
            case 5: {
                System.out.println(">Enter the name of the existing country: ");
                String countryName = existedNameChecker(newWorld);
                view.printMessage(MenuView.ENTER_NAME);
                String newName = freeNameChecker();
                view.printMessage(MenuView.ENTER_CODE);
                int newCode = codeChecker();
                newWorld.changeCountryParameters(countryName, newName, newCode);
                break;
            }
            case 6: {
                System.out.println(">Enter the name of the country to which the city belongs: ");
                String countryName = existedNameChecker(newWorld);
                System.out.println(">Enter the name of the city whose data you want to change: ");
                String cityName = existedNameChecker(newWorld);
                view.printMessage(MenuView.ENTER_CODE);
                int newCode = codeChecker();
                view.printMessage(MenuView.ENTER_RESIDENTS);
                int newResidents = checkIntValue();
                view.printMessage(MenuView.ENTER_CAPITAL);
                boolean newIsCapital = userSelectionProcessor();
                newWorld.changeCityParameters(countryName, cityName, newCode, newResidents, newIsCapital);
                break;
            }
        }
    }

    private void readDataProcessor(World newWorld) {
        view.printMessage(MenuView.READ_DATA_MENU);
        int option = checkOption();

        switch (option) {
            case 1: {
                view.printMessage(MenuView.ENTER_CODE);
                int code = checkIntValue();
                while (newWorld.idController(code)) {
                    logger.log(Level.SEVERE, MenuView.WRONG_CODE);
                    code = checkIntValue();
                }
                System.out.println(newWorld.searchObjectByCode(code));
                break;
            }
            case 2: {
                for (var country : newWorld.getCountries()) {
                    if (country != null){
                        System.out.println(country.toString());
                    }
                }
                break;
            }
            case 3: {
                view.printMessage(MenuView.ENTER_CODE);
                int code = checkIntValue();
                while (newWorld.idController(code)) {
                    logger.log(Level.SEVERE, MenuView.WRONG_CODE);
                    code = checkIntValue();
                }
                for (var city : newWorld.findAllCitiesInCountry(code)) {
                    if (city != null){
                        System.out.println(city.toString());
                    }
                }
                break;
            }
        }
    }

    private void newCityProcessor(World world) {
        boolean option = true;
        while (option) {
            System.out.println(">Enter the name of the country to which the cities will be added: ");
            String countryName = existedNameChecker(world);
            System.out.println(">Enter the number of cities to be added: ");
            int cityCounter = checkIntValue();
            for (int i = 0; i < cityCounter; i++) {
                System.out.println("\tCity №" + (i + 1));
                view.printMessage(MenuView.ENTER_NAME);
                String name = freeNameChecker();
                view.printMessage(MenuView.ENTER_CODE);
                int code = codeChecker();
                view.printMessage(MenuView.ENTER_RESIDENTS);
                int residents = checkIntValue();
                view.printMessage(MenuView.ENTER_CAPITAL);
                boolean isCapital = userSelectionProcessor();
                world.addCityToCountry(countryName, name, code, residents, isCapital);
            }
            System.out.println(">Want to keep adding cities? (yes/no): ");
            option = userSelectionProcessor();
        }
    }

    private void newCountryProcessor(World world) {
        System.out.println("Enter the number of countries you want to add: ");
        int countryCounter = checkIntValue();
        for (int i = 0; i < countryCounter; i++) {
            System.out.println("\tCountry №" + (i + 1));
            view.printMessage(MenuView.ENTER_NAME);
            String name = freeNameChecker();
            view.printMessage(MenuView.ENTER_CODE);
            int code = codeChecker();
            world.addCountry(name, code);
        }
    }

    private boolean userSelectionProcessor() {
        while (true) {
            String capitalOption = input.next();
            if (capitalOption.equals("yes")) {
                return true;
            } else if (capitalOption.equals("no")) {
                return false;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private String existedNameChecker(World world) {
        while (true) {
            String name = firstUpperCase();
            if (!world.nameController(name)) {
                return name;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private String freeNameChecker() {
        while (true) {
            String name = firstUpperCase();
            if (world.nameController(name)) {
                return name;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private int codeChecker() {
        while (true) {
            int code = checkIntValue();
            if (world.idController(code)) {
                return code;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private int checkOption() {
        while (true) {
            int option = checkIntValue();
            if (option > 0 && option < 4) {
                return option;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private int checkChangeMenuOption() {
        while (true) {
            int option = checkIntValue();
            if (option > 0 && option < 7) {
                return option;
            }
            logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
        }
    }

    private int checkIntValue() {
            while (!input.hasNextInt()) {
                logger.log(Level.SEVERE, MenuView.WRONG_INPUT_DATA);
                input.next();
            }
        return input.nextInt();
    }

    private String firstUpperCase() {
        String name = input.next();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}