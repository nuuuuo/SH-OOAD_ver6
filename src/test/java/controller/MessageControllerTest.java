package controller;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;


public class MessageControllerTest {

    private final MessageController controller = new MessageController();

    private OutputStream outputStream;
    private InputStream inputStream;

    @Test
    void reqDrinkQuantity() throws IOException {
        String jsonBody = "{\"key\":\"value\"}";
        String req = "Content-Length: " + jsonBody.length() + "\r\n\r\n" + jsonBody;
        inputStream = new ByteArrayInputStream(req.getBytes());
        outputStream = new ByteArrayOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        controller.execute("/message/drink", br, outputStream);
        String response = outputStream.toString();
        String[] body = response.split("\r\n\r\n");
        // TODO : change to correct response test
        assertEquals(body[1], jsonBody, "request drink quantity method failed!");
    }

    @Test
    void reqAdvancePayment() throws IOException {
        String jsonBody = "{\"key\":\"value\"}";
        String req = "Content-Length: " + jsonBody.length() + "\r\n\r\n" + jsonBody;
        inputStream = new ByteArrayInputStream(req.getBytes());
        outputStream = new ByteArrayOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        controller.execute("/message/pay", br, outputStream);
        String response = outputStream.toString();
        String[] body = response.split("\r\n\r\n");
        // TODO : change to correct response test
        assertEquals(body[1], jsonBody, "request drink quantity method failed!");
    }

}
