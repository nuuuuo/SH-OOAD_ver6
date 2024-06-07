package controller;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DrinkControllerTest {

    private final MessageController controller = new MessageController();

    private OutputStream outputStream;
    private InputStream inputStream;

    @Test
    void getMenuList() {
        outputStream = new ByteArrayOutputStream();
        //controller.execute();
    }

}
