package com.iluwatar.visitor.example2;

public class ConcreteElement2 extends Element {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
