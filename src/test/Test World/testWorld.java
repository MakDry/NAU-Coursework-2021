import BLL.World;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testWorld {
    private World world;

    @BeforeEach
    void testSetUp(){
        world = new World();
    }

    @Test
    void testChangeCityParameters(){
        world.addCountry("Ukraine", 9090);
        world.addCityToCountry("Ukraine", "Kiev", 1010, 2800000, true);
        world.addCityToCountry("Ukraine", "Cherkasy", 3030, 700000, false);
        world.changeCityParameters("Ukraine", "Kiev", 1010, 10000, false);
        Assertions.assertEquals("\nCity data:\n" +
                "1. City name: Kiev\n" +
                "2. Unique code: 1010\n" +
                "3. Number of residents: 10000\n" +
                "4. Capital status: false", world.searchObjectByCode(1010));
    }

    @Test
    void testChangeCountryParameters(){
        world.addCountry("Ukraine", 2020);
        world.changeCountryParameters("Ukraine", "Poland", 3030);
        Assertions.assertEquals("Poland", world.getCountries()[0].getName());
    }

    @Test
    void testSearchCityInCountry(){
        world.addCountry("Ukraine", 9090);
        world.addCityToCountry("Ukraine", "Kiev", 1010, 2800000, true);
        world.addCityToCountry("Ukraine", "Cherkasy", 3030, 700000, false);
        Assertions.assertEquals("\nCity data:\n" +
                "1. City name: Kiev\n" +
                "2. Unique code: 1010\n" +
                "3. Number of residents: 2800000\n" +
                "4. Capital status: true", world.searchObjectByCode(1010));
    }

    @Test
    void testSearchCountry(){
        world.addCountry("Ukraine", 9090);
        world.addCountry("Poland", 2020);
        Assertions.assertEquals("\nCountry data: \n" +
                "1. Country name: Ukraine\n" +
                "2. Unique code: 9090", world.searchObjectByCode(9090));
    }

    @Test
    void testRemoveCountry(){
        world.addCountry("Ukraine", 9090);
        world.addCountry("Poland", 2020);
        world.removeCountry("Ukraine");
        Assertions.assertNull(world.getCountries()[0]);
    }

    @Test
    void testAddCountry(){
        world.addCountry("Ukraine", 9090);
        world.addCountry("Poland", 2020);
        Assertions.assertEquals("Poland", world.getCountries()[1].getName());
    }

    @Test
    void testRemoveCityFromCountry(){
        world.addCountry("Ukraine", 2020);
        world.addCityToCountry("Ukraine", "Kiev", 1010, 2800000, true);
        world.removeCityFromCountry("Ukraine", "Kiev");
        Assertions.assertNull(world.searchObjectByCode(1010));
    }

    @Test
    void testAddCityToCountry(){
        world.addCountry("Ukraine", 2020);
        world.addCityToCountry("Ukraine", "Kiev", 1010, 2800000, true);
        world.addCityToCountry("Ukraine", "Cherkasy", 3030, 700000, false);
        Assertions.assertEquals("Kiev", world.findAllCitiesInCountry(2020)[0].getName());
    }
}