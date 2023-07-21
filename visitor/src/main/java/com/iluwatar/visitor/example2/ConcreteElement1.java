package com.iluwatar.visitor.example2;

public class ConcreteElement1 extends Element {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
