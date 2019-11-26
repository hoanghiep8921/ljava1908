package oop;

public class Square extends Shape {

    public Square(int a,String name) {
        super(a,name);
    }
    @Override
    public int area() {
        int s = a*a;
        return s;
    }

    @Override
    public void print() {
        System.out.println("Diện tích của hình " + name + " là :" + area() );
    }

}
