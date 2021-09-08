package ru.job4j.odd;

import java.util.ArrayList;
import java.util.List;

public class MultiClass implements MultiInerface {
    @Override
    public List<Integer> adjustment(List<Integer> lstInt) {
        EvenNumbers evenNumbers = new EvenNumbers();
        return evenNumbers.adjust(lstInt);
    }

    @Override
    public void print(List<String> lstStr) {
        AnyPrint anyPrint = new AnyPrint();
        anyPrint.print(lstStr);
    }
}

class AnyPrint {
    void print(List<String> lstStr) {
        lstStr.forEach(System.out::println);
    }
}

class EvenNumbers {
    List<Integer> adjust(List<Integer> lstInt) {
        List<Integer> lstEven = new ArrayList<>();
        for (var elm : lstInt) {
            if (elm / 2 == 0) {
                lstEven.add(elm);
            }
        }
        return lstEven;
    }
}