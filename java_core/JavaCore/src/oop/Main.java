package oop;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10,10,"Tam giác");
        Square square = new Square(5,"Hình vuông");
        Circle circle = new Circle(10,"Hình tròn");

        triangle.print();
        square.print();
        circle.print();

    }
}
