package manager;

import data.AdminAccount;
import db.AdminDBManager;

public class AdminAccountManager {

    public boolean checkUser(AdminAccount account) {
        // TODO implement here
        AdminDBManager adminDBManager = AdminDBManager.getManager();
        return adminDBManager.checkUser(account);
    }

    public boolean logout() {
        // TODO implement here
        return true;
    }////////이게 끝인가...?

}