package data;

public class VerificationCode {

    public VerificationCode(String code, String drinkType, int drinkNum) {
        this.code = code;
        this.drinkType = drinkType;
        this.drinkNum = drinkNum;
    }

    private final String code;

    private final String drinkType;

    private final int drinkNum;

    public String getCode() {
        return code;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public int getDrinkNum() {
        return drinkNum;
    }

}