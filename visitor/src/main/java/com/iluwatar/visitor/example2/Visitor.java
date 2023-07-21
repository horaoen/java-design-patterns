package com.iluwatar.visitor.example2;

public class Visitor implements IVisitor{
    @Override
    public void visit(ConcreteElement1 element) {
        System.out.println("visit: " + element.getClass().getSimpleName());
    }

    @Override
    public void visit(ConcreteElement2 element) {
        System.out.println("visit: " + element.getClass().getSimpleName());
        System.out.println(element);
    }
}
