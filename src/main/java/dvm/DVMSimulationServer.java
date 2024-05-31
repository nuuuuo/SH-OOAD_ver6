package dvm;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DVMSimulationServer {

    private ControllerMapper controllerMapper;

    public static void main(String[] args) {
        ControllerMapper mapper = new ControllerMapper();

        int port = 9000;
        ExecutorService service = Executors.newFixedThreadPool(50);

        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket welcomeSocket = new ServerSocket(port)){
            Socket connection;
            while ((connection = welcomeSocket.accept()) != null) {
                Socket finalConnection = connection;
                // set task to new thread & execute controller
                service.submit(() -> {
                    try(InputStream is = finalConnection.getInputStream();
                        OutputStream os = finalConnection.getOutputStream()) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        DataOutputStream dos = new DataOutputStream(os);

                        String startLine = br.readLine();
                        String[] startLines = startLine.split(" ");
                        String method = startLines[0];
                        String url = startLines[1];

                        dos.writeChars("Hello! -> " + method + " : " + url);
                        dos.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
