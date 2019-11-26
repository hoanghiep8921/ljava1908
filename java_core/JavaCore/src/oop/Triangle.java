package oop;

public class Triangle extends Shape{
    private int h;

    public Triangle(int h,int a,String name) {
        super(a,name);
        this.h = h;
    }


    public int area() {
        int s = (a*h)/2;
        return s;
    }

    public void print() {
        System.out.println("Diện tích của hình " + name + " là :" + area() );
    }

    public void showAttribute(){
        System.out.println("Chiều cao là : "+h);
        System.out.println("Tên hình là : "+name);
        System.out.println("Cạnh đáy là : "+a);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
