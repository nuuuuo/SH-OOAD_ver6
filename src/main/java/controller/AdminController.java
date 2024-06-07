package controller;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class AdminController implements Controller {

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);
        System.out.println(url);
        if(Objects.equals(url, "/admin/login")) login(dos, url);
        else if(Objects.equals(url, "/admin/logout")) logout(dos, url);
        else if(Objects.equals(url, "/admin/manage")) manageDrink(dos, url);
    }

    private void login(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        dos.flush();
    }

    private void logout(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        dos.flush();
    }

    private void manageDrink(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        dos.flush();
    }

}