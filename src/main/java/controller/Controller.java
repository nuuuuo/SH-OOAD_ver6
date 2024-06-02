package controller;

import java.io.*;

public interface Controller {

    public void execute(String url, BufferedReader br, OutputStream os) throws IOException;

}