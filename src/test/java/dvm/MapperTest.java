package dvm;

import controller.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapperTest {

    private final ControllerMapper mapper = new ControllerMapper();

    private String getInstanceErrorMsg(Class<?> clazz) {
        return "Instance should be of type " + clazz.getName();
    }

    @Test
    void getAdminController() {
        Controller controller = mapper.getController("/admin/login");
        assertInstanceOf(AdminController.class, controller, getInstanceErrorMsg(AdminController.class));
    }

    @Test
    void getDrinkController() {
        Controller controller = mapper.getController("/drink");
        assertInstanceOf(DrinkController.class, controller, getInstanceErrorMsg(DrinkController.class));
    }

    @Test
    void getMessageController() {
        Controller controller = mapper.getController("/message/send");
        assertInstanceOf(MessageController.class, controller, getInstanceErrorMsg(MessageController.class));
    }

    @Test
    void getPayController() {
        Controller controller = mapper.getController("/pay");
        assertInstanceOf(PayController.class, controller, getInstanceErrorMsg(PayController.class));
    }

    @Test
    void getVerificationCodeController() {
        Controller controller = mapper.getController("/code");
        assertInstanceOf(VerificationCodeController.class, controller, getInstanceErrorMsg(VerificationCodeController.class));
    }

    @Test
    void notProperUrl() {
        Controller controller = mapper.getController("/wrong");
        assertNull(controller);

        controller = mapper.getController("");
        assertNull(controller);
    }

}
