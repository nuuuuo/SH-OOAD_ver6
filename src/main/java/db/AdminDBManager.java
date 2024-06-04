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

    public boolean checkUser(AdminAccount account) {
        // TODO implement here
        return false;
    }////////////checkUser의 리턴값을 void -> boolean으로 변경

}