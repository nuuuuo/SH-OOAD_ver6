package controller;

import org.json.JSONObject;
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
        //        while ((c = (char) br.read()) != '') {
//            sb.append(c);
//        }
        String result = br.readLine();
        result = '{' + result;
        System.out.println(result);
        dos.writeBytes("hello1");
        //dos.flush();

        JSONObject jsonObject = new JSONObject(result);
        String msgType = (String) jsonObject.get("msg_type");
        System.out.println(msgType);
        dos.writeBytes("hello2");
        //dos.flush();

        if(Objects.equals(msgType, "req_stock"))
            reqDrinkQuantity(dos, result);
        else if(Objects.equals(msgType, "req_prepay"))
            reqAdvancePayment(dos, result);
    }

    private void reqDrinkQuantity(DataOutputStream dos, String body) throws IOException {
        JSONObject jsonObject = new JSONObject(body);
        JSONObject content = jsonObject.getJSONObject("msg_content");

        System.out.println("req: " + body);

        String msg_type = "resp_stock";
        String src_id = "Team2";
        String dst_id = jsonObject.get("src_id").toString();
        String item_code = content.get("item_code").toString();

        DrinkManager manager = new DrinkManager();
        int item_num = manager.getDrinkQuantity(item_code);
        int coor_x = myDVM.getX();
        int coor_y = myDVM.getY();

        String jsonString = String.format(
                "{ \"msg_type\": \"%s\", \"src_id\": \"%s\", \"dst_id\": \"%s\", \"msg_content\": { \"item_code\": \"%s\", \"item_num\": %d, \"coor_x\": %d, \"coor_y\": %d } }",
                msg_type, src_id, dst_id, item_code, item_num, coor_x, coor_y
        );
        System.out.println(jsonString);

        dos.writeBytes(jsonString);
        dos.flush();
    }

    private void reqAdvancePayment(DataOutputStream dos, String body) throws IOException {
        JSONObject jsonObject = new JSONObject(body);
        JSONObject content = jsonObject.getJSONObject("msg_content");

        String msg_type = "resp_stock";
        String src_id = "Team2";
        String dst_id = jsonObject.get("src_id").toString();
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