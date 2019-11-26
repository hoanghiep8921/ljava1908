package oop;

public abstract class Shape {
    protected int a;
    protected String name;

    public Shape(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public abstract int area();
    public abstract void print();
}
