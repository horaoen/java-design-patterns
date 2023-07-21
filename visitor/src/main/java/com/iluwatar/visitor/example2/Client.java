package com.iluwatar.visitor.example2;

public class Client {
    public static void main(String[] args) {
        Element e1 = new ConcreteElement1();
        Element e2 = new ConcreteElement2();
        
        e1.accept(new Visitor());
        e2.accept(new Visitor());
    }
}
