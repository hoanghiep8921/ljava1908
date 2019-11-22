package kickball;

public class Main {
    public static void main(String[] args) {
        Ball b = new Ball(3,0);
//        System.out.println("Giá trị m "+b.m);
//
//        System.out.println("Giá trị distance "+b.distance);
        Person p = new Person(10);
        p.kick(b);
        p.kick(b);
    }
}
