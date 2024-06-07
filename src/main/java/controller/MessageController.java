package controller;

import com.google.gson.Gson;
import data.DVM;
import data.VerificationCode;
import manager.DrinkManager;
import manager.VerificationManager;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class MessageController implements Controller {

    private final DVM myDVM;

    public MessageController() {
        myDVM = new DVM(12, 7);
    }

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);

        System.out.println(url);
        StringBuilder sb = new StringBuilder();
        char c;
        while ((c = (char) br.read()) != '}') {
            sb.append(c);
        }
        String result = sb.toString();
        result = "{" + result + "}}";
        System.out.println(result);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(result, Map.class);
        String msgType = (String) map.get("msg_type");

        if(Objects.equals(msgType, "req_stock"))
            reqDrinkQuantity(dos, result);
        else if(Objects.equals(msgType, "req_prepay"))
            reqAdvancePayment(dos, result);
    }

    private void reqDrinkQuantity(DataOutputStream dos, String body) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(body, Map.class);
        Map<String, Object> content = gson.fromJson(map.get("msg_content").toString(), Map.class);

        String msg_type = "resp_stock";
        String src_id = "Team2";
        String dst_id = map.get("src_id").toString();
        String item_code = content.get("item_code").toString();

        DrinkManager manager = new DrinkManager();
        int item_num = manager.getDrinkQuantity(item_code);
        int coor_x = myDVM.getX();
        int coor_y = myDVM.getY();

        String jsonString = String.format(
                "{ \"msg_type\": \"%s\", \"src_id\": \"%s\", \"dst_id\": \"%s\", \"msg_content\": { \"item_code\": \"%s\", \"item_num\": %d, \"coor_x\": %d, \"coor_y\": %d } }",
                msg_type, src_id, dst_id, item_code, item_num, coor_x, coor_y
        );

        dos.writeBytes(jsonString);
        dos.flush();
    }

    private void reqAdvancePayment(DataOutputStream dos, String body) throws IOException {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(body, Map.class);
        Map<String, Object> content = gson.fromJson(map.get("msg_content").toString(), Map.class);

        String msg_type = "resp_stock";
        String src_id = "Team2";
        String dst_id = map.get("src_id").toString();
        String item_code = content.get("item_code").toString();
        int item_num = (int)(double) content.get("item_num");
        boolean availability;

        DrinkManager drinkManager = new DrinkManager();
        VerificationManager verificationManager = new VerificationManager();
        if(drinkManager.hasDrink(item_code, item_num)) {
            VerificationCode code = new VerificationCode(content.get("cert_code").toString(), item_code, item_num);
            availability = verificationManager.saveCode(code);
        } else availability = false;

        String jsonString = String.format(
                "{ \"msg_type\": \"%s\", \"src_id\": \"%s\", \"dst_id\": \"%s\", \"msg_content\": { \"item_code\": \"%s\", \"item_num\": %d, \"availability\": %b } }",
                msg_type, src_id, dst_id, item_code, item_num, availability
        );

        dos.writeBytes(jsonString);
        dos.flush();
    }

}