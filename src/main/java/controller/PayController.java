package controller;

import data.Card;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PayController implements Controller {

    private String drinkType;

    private int drinkNum;

    private Card card;

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) {
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
