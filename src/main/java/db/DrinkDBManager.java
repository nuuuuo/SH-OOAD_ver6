package db;

import data.Drink;
import java.util.List;

public class DrinkDBManager implements DBManager {

    private String dbPath;

    private static final DrinkDBManager manager = new DrinkDBManager();

    private DrinkDBManager() {
        // TODO implement here
    }

    public static DrinkDBManager getManager() {
        return manager;
    }

    public Boolean hasDrink(String drinkType, int drinkNum) {
        // TODO implement here
        return null;
    }

    public Drink getDrink(String drinkType, int drinkNum) {
        // TODO implement here
        return null;
    }

    public int getDrinkQuantity(String drinkType) {
        // TODO implement here
        return 0;
    }

    public Boolean setDrink(String drinkType, int drinkNum) {
        // TODO implement here
        return null;
    }

    public List<Drink> getAllDrinkStatus() {
        // TODO implement here
        return null;
    }

    public List<Drink> getMenuList() {
        // TODO implement here
        return null;
    }

}