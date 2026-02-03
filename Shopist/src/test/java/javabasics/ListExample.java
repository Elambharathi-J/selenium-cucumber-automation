package javabasics;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> l= new ArrayList<Integer>();
        l.add(45);
        l.add(56);
        System.out.println(l);
        l.add(78);
        System.out.println(l);
        System.out.println(l.get(2));
    }
}
