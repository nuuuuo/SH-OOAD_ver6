package controller;

import manager.DrinkManager;
import manager.VerificationManager;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class VerificationCodeController implements Controller {

    public VerificationManager verificationManager;

    public DrinkManager drinkManager;

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) {
        // TODO implement here
    }

    private void verifyCode(DataOutputStream dos, String body) {
        // TODO implement here
    }

}