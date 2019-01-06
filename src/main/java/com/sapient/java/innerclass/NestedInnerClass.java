package com.sapient.java.innerclass;

import com.sun.xml.internal.bind.marshaller.NioEscapeHandler;

public class NestedInnerClass {

    private String str = "Ankit";

    public class Nested {
        private String s1 = "s1";

//        private String str = "Gupta";
        public void fun(){
            System.out.println("inside fun "+ str);
        }
    }

    public void fun(){
        System.out.println("Inside Nested Parent class ");
        new Nested().fun();
    }

}
