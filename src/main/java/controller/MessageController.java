package controller;

import data.DVM;
import manager.DrinkManager;
import manager.VerificationManager;
import java.io.DataOutputStream;
import java.net.Socket;

public class MessageController implements Controller {

    public MessageController() {
    }

    public DrinkManager drinkManager;

    public VerificationManager verificationManager;

    private DVM myDVM;

    public void MessageController() {
        // TODO implement here
    }

    @Override
    public void execute(String url, Socket connection) {
        // TODO implement here
    }

    public void reqLocation() {
        // TODO implement here
    }

    private void reqDrinkQuantity(DataOutputStream dos, String body) {
        // TODO implement here
    }

    private void reqAdvancePayment(DataOutputStream dos, String body) {
        // TODO implement here
    }

}