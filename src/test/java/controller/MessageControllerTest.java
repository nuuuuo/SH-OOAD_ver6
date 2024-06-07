package controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class MessageControllerTest {

    private final MessageController controller = new MessageController();

    private OutputStream outputStream;
    private InputStream inputStream;

    @Test
    void reqDrinkQuantity() throws IOException {
        String jsonBody = "\n" +
                "  \"msg_type\": \"req_stock\",\n" +
                "  \"src_id\": \"Team1\",\n" +
                "  \"dst_id\": \"0\",\n" +
                "  \"msg_content\": {\n" +
                "    \"item_code\": \"05\",\n" +
                "    \"item_num\": 25\n" +
                "  }\n" +
                "}";

        inputStream = new ByteArrayInputStream(jsonBody.getBytes());
        outputStream = new ByteArrayOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        controller.execute("message", br, outputStream);
        String response = outputStream.toString();
        System.out.println(response);

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(response, Map.class);
        Map<String, Object> content = gson.fromJson(map.get("msg_content").toString(), Map.class);

        assertEquals(map.get("msg_type").toString(), "resp_stock", "request drink quantity method failed!");
        assertEquals(map.get("src_id").toString(), "Team2", "request drink quantity method failed!");
        assertEquals(map.get("dst_id").toString(), "Team1", "request drink quantity method failed!");

        assertEquals(content.get("item_code").toString(), "05", "request drink quantity method failed!");
        assertEquals(content.get("coor_x"), 12.0, "request drink quantity method failed!");
        assertEquals(content.get("coor_y"), 7.0, "request drink quantity method failed!");
    }

    @Test
    void reqAdvancePayment() throws IOException {
        String jsonBody = "\n" +
                "  \"msg_type\": \"req_prepay\",\n" +
                "  \"src_id\": \"Team1\",\n" +
                "  \"dst_id\": \"0\",\n" +
                "  \"msg_content\": {\n" +
                "    \"item_code\": \"05\",\n" +
                "    \"item_num\": 5,\n" +
                "    \"cert_code\": \"cxf01\"\n" +
                "  }\n" +
                "}";

        inputStream = new ByteArrayInputStream(jsonBody.getBytes());
        outputStream = new ByteArrayOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        controller.execute("message", br, outputStream);
        String response = outputStream.toString();
        System.out.println(response);

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(response, Map.class);
        Map<String, Object> content = gson.fromJson(map.get("msg_content").toString(), Map.class);

        assertEquals(map.get("msg_type").toString(), "resp_stock", "request drink quantity method failed!");
        assertEquals(map.get("src_id").toString(), "Team2", "request drink quantity method failed!");
        assertEquals(map.get("dst_id").toString(), "Team1", "request drink quantity method failed!");

        assertEquals(content.get("item_code").toString(), "05", "request drink quantity method failed!");
        assertEquals(content.get("item_num"), 5.0, "request drink quantity method failed!");
        assertEquals(content.get("availability"), false, "request drink quantity method failed!");
    }

}
