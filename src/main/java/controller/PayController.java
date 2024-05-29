package controller;

import data.Card;
import java.io.DataOutputStream;
import java.net.Socket;

public class PayController implements Controller {

    private String drinkType;

    private int drinkNum;

    private Card card;

    @Override
    public void execute(String url, Socket connection) {
        // TODO implement here
    }

    private void setDrink(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void setDrinkNum(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void isPayAvailable(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void isPrepayAvailable(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void pay(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void prepay(DataOutputStream dos, String body) {
        // TODO implement here
    }

}
