package oop;

public class Rectangle extends Shape implements Caculate,Test {

    public Rectangle(int a, String name) {
        super(a, name);
    }

    @Override
    public int area() {
        return 0;
    }

    @Override
    public void print() {

    }

    @Override
    public void abc() {

    }
}
