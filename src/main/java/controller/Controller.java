package controller;

import java.net.Socket;

public interface Controller {

    public void execute(String url, Socket connection);

}