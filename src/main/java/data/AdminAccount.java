package data;

public class AdminAccount {

    public AdminAccount(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    private final String id;

    private final String pwd;

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

}