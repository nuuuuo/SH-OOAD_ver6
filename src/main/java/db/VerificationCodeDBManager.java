package db;

import data.VerificationCode;

public class VerificationCodeDBManager implements DBManager {

    private String dbPath;

    private static final VerificationCodeDBManager manager = new VerificationCodeDBManager();

    private VerificationCodeDBManager() {
        // TODO implement here
    }

    public static VerificationCodeDBManager getManager() {
        return manager;
    }

    public VerificationCode checkCode(String code) {
        // TODO implement here
        return null;
    }

    public Boolean saveCode(String code) {
        // TODO implement here
        return null;
    }

}