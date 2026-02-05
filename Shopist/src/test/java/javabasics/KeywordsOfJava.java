package javabasics;

public class KeywordsOfJava extends SuperKeywordExample{

    int a=100;

    public static void main(String[] args) {
        KeywordsOfJava k = new KeywordsOfJava();
        k.m1();
    }

    public void m1(){
        int a=23;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
    }
    public void m2(){

    }
}
