package kickball;

public class Person {

    public Person(int f) {
        this.f = f;
    }

    int f;

    void kick(Ball ball){
        System.out.println( "Vị trí sau khi sút là : " + ball.move(f));
    }
}
