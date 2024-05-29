package db;

import data.AdminAccount;

public class AdminDBManager implements DBManager {

    private String dbPath;

    private static final AdminDBManager manager = new AdminDBManager();

    private AdminDBManager() {
        // TODO implement here
    }

    public static AdminDBManager getManager() {
        return manager;
    }

    public void checkUser(AdminAccount account) {
        // TODO implement here
    }

}
