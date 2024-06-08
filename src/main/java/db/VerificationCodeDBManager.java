package db;

import data.VerificationCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VerificationCodeDBManager implements DBManager {

    private String dbPath = "src/main/resources/verificationCode.txt";

    private static final VerificationCodeDBManager manager = new VerificationCodeDBManager();

    private VerificationCodeDBManager() {
        // 파일이 존재하는지 확인하고, 없으면 생성
        try {
            FileReader fileReader = new FileReader(dbPath);
            fileReader.close();
        } catch (IOException e) {
            try {
                FileWriter fileWriter = new FileWriter(dbPath);
                fileWriter.write(
                        "asd123asd1 콜라 10\n" +
                                "asd123asd2 사이다 10\n" +
                                "asd123asd3 홍차 10\n" +
                                "asd123asd4 녹차 10\n" +
                                "asd123asd5 밀크티 10\n");
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static VerificationCodeDBManager getManager() {
        return manager;
    }

    public VerificationCode checkCode(String code) { // 코드가 존재하면 VerificationCode 객체를 반환하고, 존재하지 않으면 null을 반환
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3 && parts[0].equals(code)) {
                    String drinkType = parts[1];
                    int drinkNum = Integer.parseInt(parts[2]);
                    return new VerificationCode(code, drinkType, drinkNum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean saveCode(VerificationCode code) {
        if (checkCode(code.getCode()) != null) { //코드가 이미 존재함
            return false;
        }

        try (FileWriter fileWriter = new FileWriter(dbPath, true)) {
            fileWriter.write(code.getCode() + " " + code.getDrinkType() + " " + code.getDrinkNum() + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}