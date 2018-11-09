package com.sapient.java.methodlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MethodLocalOuterClass {

    private String str1 = "Outer Class";
    private int i=0;

    public void fun(){
        class InnerClass{
            private String str = "Inner Class";

            public void innerFun(){
                String localVar;
                localVar = "Method local variable";
                System.out.println("Able to access" + " "+str +" variable.");
                System.out.println("trying to Access "+ str1);
                System.out.println("Trying to access "+ localVar);
            }
        }

        new InnerClass().innerFun();
    }

}


class MainClass{
    public static void main(String[] args) {
        ExecutorService fixedthreadPool = Executors.newFixedThreadPool(10);

        MethodLocalOuterClass outer = new MethodLocalOuterClass();
        outer.fun();
    }
}