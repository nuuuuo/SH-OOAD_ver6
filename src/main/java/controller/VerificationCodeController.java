package controller;

import manager.DrinkManager;
import manager.VerificationManager;
import java.io.DataOutputStream;
import java.net.Socket;

public class VerificationCodeController implements Controller {

    public VerificationManager verificationManager;

    public DrinkManager drinkManager;

    @Override
    public void execute(String url, Socket connection) {
        // TODO implement here
    }

    private void verifyCode(DataOutputStream dos, String body) {
        // TODO implement here
    }

}