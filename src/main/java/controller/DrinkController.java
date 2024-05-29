package controller;

import manager.DrinkManager;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

public class DrinkController implements Controller {

    public List<String> MenuList;

    public DrinkManager drinkManager;

    @Override
    public void execute(String url, Socket connection) {
        // TODO implement here
    }

    private void getMenuList(DataOutputStream dos, String body) {
        // TODO implement here
    }

}