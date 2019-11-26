package oop;

public class Circle extends Shape {

    public Circle(int a, String name) {
        super(a, name);
    }

    @Override
    public int area() {
        int s = (int) (Math.PI * a*a);
        return s;
    }

    @Override
    public void print() {
        System.out.println("Diện tích của hình " + name + " là :" + area() );
    }
}
