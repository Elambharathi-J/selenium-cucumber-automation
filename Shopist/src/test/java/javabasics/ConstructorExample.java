package javabasics;

public class ConstructorExample {

    static int a;
    static String b;

    public ConstructorExample(){
        a=1;
    }

    public ConstructorExample(String b){
        this.b=b;

    }
    public static void main(String[] args) {

        ConstructorExample c = new ConstructorExample("Elam");

        System.out.println(b);

    }
}
