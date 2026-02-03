package javabasics;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> s= new HashSet<Integer>();
        s.add(45);
        s.add(56);
        System.out.println(s);

        for (Integer n:s){
            System.out.println(n);
        }
    }
}
