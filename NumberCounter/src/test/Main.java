package test;

import model.CounterModel;
import view.CounterView;

public class Main {
    public static void main(String[] args) {
        CounterModel ct = new CounterModel();
        ct.increment();
        ct.increment();
        ct.increment();
        System.out.println(ct.getValue());
        CounterView ctv = new CounterView();
    }
}
