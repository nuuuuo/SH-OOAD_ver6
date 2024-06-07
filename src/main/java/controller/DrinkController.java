package controller;

import com.google.gson.Gson;
import manager.DrinkManager;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class DrinkController implements Controller {

    public List<String> MenuList;

    public DrinkManager drinkManager;

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);
        getMenuList(dos, "");
    }

    private void getMenuList(DataOutputStream dos, String body) throws IOException {
        DrinkManager manager = new DrinkManager();
        List list = manager.getMenuInfo();
        Gson gson = new Gson();
        String json = gson.toJson(list);

        dos.writeBytes(json);
        dos.flush();
    }

}