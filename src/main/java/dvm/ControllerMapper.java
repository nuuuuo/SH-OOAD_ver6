package dvm;

import controller.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ControllerMapper {

    private final Map<String, Controller> controllers;

    public ControllerMapper() {
        controllers = new HashMap<>();
        controllers.put("/admin", new AdminController());
        controllers.put("/drink", new DrinkController());
        controllers.put("/message", new MessageController());
        controllers.put("/pay", new PayController());
        controllers.put("/code", new VerificationCodeController());
    }

    public Controller getController(String url) {
        return controllers.get(url);
    }

}