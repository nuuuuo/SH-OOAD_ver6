package dvm;

import controller.*;
import java.util.HashMap;
import java.util.Map;

public class ControllerMapper {

    private final Map<String, Controller> controllers;

    public ControllerMapper() {
        controllers = new HashMap<>();
        controllers.put("admin", new AdminController());
        controllers.put("drink", new DrinkController());
        controllers.put("message", new MessageController());
        controllers.put("pay", new PayController());
        controllers.put("code", new VerificationCodeController());
    }

    public Controller getController(String url) {
        String[] urls = url.split("/");
        if(urls.length < 2)
            return null;
        return controllers.get(urls[1]);
    }

}