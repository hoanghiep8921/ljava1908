package kickball;

public class Ball {
    int m;
    int distance;

    Ball(int m,int distance){
        this.m= m;
        this.distance = distance;
    }

    int move(int f){
        int s = f * m;
        this.distance += s;
        return this.distance;
    }

    void moveAnother(int f){
        int s = f * m;
        this.distance += s;
        System.out.println("Khoảng cách hiện tại là :" + this.distance);
    }
}
