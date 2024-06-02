package controller;

import manager.DrinkManager;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class DrinkController implements Controller {

    public List<String> MenuList;

    public DrinkManager drinkManager;

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) {
        // TODO implement here
    }

    private void getMenuList(DataOutputStream dos, String body) {
        // TODO implement here
    }

}