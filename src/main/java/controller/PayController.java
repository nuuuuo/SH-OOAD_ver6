package controller;

import data.Card;
import data.DVM;
import data.VerificationCode;
import manager.DVMContactManager;
import manager.DrinkManager;
import manager.PaymentManager;
import manager.VerificationManager;

import java.io.*;
import java.net.Socket;

public class PayController implements Controller {

    private String drinkType;

    private int drinkNum;

    private Card card;

    @Override
    public void execute(String url, BufferedReader br, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);

        int contentLength = 0;
        while (true) {
            final String line = br.readLine();
            if(line.isEmpty()) break;
            if (line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split(": ")[1]);
            }
        }
        char[] body = new char[contentLength];
        br.read(body, 0, contentLength);
        String data = String.copyValueOf(body);

        if(url == "/pay/setDrink") setDrink(dos, data);
        else if(url == "/pay/setDrinkNum") setDrinkNum(dos, data);
        else if(url == "/pay/isPayAvailable") isPayAvailable(dos, data);
        else if(url == "/pay/isPrepayAvailable") isPrepayAvailable(dos, data);
        else if(url == "/pay/pay") pay(dos, data);
        else if(url == "/pay/prepay") prepay(dos, data);
    }

    private void setDrink(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        drinkType = body;
        dos.flush();
    }

    private void setDrinkNum(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        drinkNum = Integer.parseInt(body);
        dos.flush();
    }

    private void isPayAvailable(DataOutputStream dos, String body) throws IOException {
        DrinkManager drinkManager = new DrinkManager();
        if(drinkManager.hasDrink(drinkType, drinkNum))
            dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        else {
            DVMContactManager contactManager = new DVMContactManager();
            DVM dvm = contactManager.searchDrink(drinkType, drinkNum);
            if(dvm != null) {
                String res = "HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n";
                res += dvm.getX();
                res += " ";
                res += dvm.getY();
                dos.writeBytes(res);
            } else dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n no"));
        }
        dos.flush();
    }

    private void isPrepayAvailable(DataOutputStream dos, String body) throws IOException {
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        dos.flush();
    }

    private void pay(DataOutputStream dos, String body) throws IOException {
        PaymentManager paymentManager = new PaymentManager();
        String res = paymentManager.reqPay(new Card(body));
        dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n" + res));
        dos.flush();
    }

    private void prepay(DataOutputStream dos, String body) throws IOException {
        VerificationManager verificationManager = new VerificationManager();
        String code = verificationManager.getVerificationCode();

        DVMContactManager contactManager = new DVMContactManager();
        if(contactManager.reqAdvancePayment(drinkType, drinkNum, code)) {
            VerificationCode verifyCode = new VerificationCode(code, drinkType, drinkNum);
            verificationManager.saveCode(verifyCode);

            dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        } else dos.writeBytes(("HTTP/1.1 200 OK \r\n Content Type: text/html;charset=utf-8 \r\n\r\n ok"));
        dos.flush();
    }

}
