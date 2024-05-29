package data;

public class Drink {

    public Drink(int id, String drinkName, int drinkPrice, int drinkNum) {
        this.id = id;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkNum = drinkNum;
    }

    private final int id;

    private final String drinkName;

    private final int drinkPrice;

    private final int drinkNum;

    public int getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public int getDrinkNum() {
        return drinkNum;
    }

}