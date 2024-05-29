package dvm;

import controller.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapperTest {

    private String getInstanceErrorMsg(Class<?> clazz) {
        return "Instance should be of type " + clazz.getName();
    }

    @Test
    void getAdminController() {
        ControllerMapper mapper = new ControllerMapper();
        Controller controller = mapper.getController("/admin");
        assertInstanceOf(AdminController.class, controller, getInstanceErrorMsg(AdminController.class));
    }

    @Test
    void getDrinkController() {
        ControllerMapper mapper = new ControllerMapper();
        Controller controller = mapper.getController("/drink");
        assertInstanceOf(DrinkController.class, controller, getInstanceErrorMsg(DrinkController.class));
    }

    @Test
    void getMessageController() {
        ControllerMapper mapper = new ControllerMapper();
        Controller controller = mapper.getController("/message");
        assertInstanceOf(MessageController.class, controller, getInstanceErrorMsg(MessageController.class));
    }

    @Test
    void getPayController() {
        ControllerMapper mapper = new ControllerMapper();
        Controller controller = mapper.getController("/pay");
        assertInstanceOf(PayController.class, controller, getInstanceErrorMsg(PayController.class));
    }

    @Test
    void getVerificationCodeController() {
        ControllerMapper mapper = new ControllerMapper();
        Controller controller = mapper.getController("/code");
        assertInstanceOf(VerificationCodeController.class, controller, getInstanceErrorMsg(VerificationCodeController.class));
    }

}
