package controller;

import data.DVM;
import manager.DrinkManager;
import manager.VerificationManager;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MessageController implements Controller {

    private DVM myDVM;

    public MessageController() {
    }

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);

        int contentLength = 0;
        while (true) {
            final String line = br.readLine();
            if(line.isEmpty()) break;
            if (line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split(": ")[1]);
            }
        }
        char[] body = new char[contentLength];
        br.read(body, 0, contentLength);
        String data = String.copyValueOf(body);

        if(Objects.equals(url, "/message/drink"))
            reqDrinkQuantity(dos, data);
        else if(Objects.equals(url, "/message/pay"))
            reqAdvancePayment(dos, data);
    }

    private void reqDrinkQuantity(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n"));
        dos.writeBytes(body);
        dos.flush();
    }

    private void reqAdvancePayment(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n"));
        dos.writeBytes(body);
        dos.flush();
    }

}