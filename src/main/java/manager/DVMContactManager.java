package manager;

import data.DVM;
import java.util.*;

public class DVMContactManager {

    private List<String> anotherDVMAddresses;

    public DVM searchDrink(String drinkType, int drinkNum) {
        // TODO implement here
        //usecase3, usecase11

        // AnotherVM에게 searchDrink(drinkType, drinkNum) 실행시키기. drinkInfo 리턴받기


        return calculateNearestVM();
    }

    public boolean reqAdvancePayment(String drinkType, int drinkNum, String code) {
        // TODO implement here
        //usecase4 : anotherVM과의 소통. 선결제 가능 여부 확인 요청
        //usecase6
        return false;
    }

    private DVM calculateNearestVM() {
        // TODO implement here
        return null;
    }

}