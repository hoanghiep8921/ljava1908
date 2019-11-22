package boxing;

import java.util.Random;

public class Boxer {
    String name;
    int damage;
    int hp;
    int missRate;

    public Boxer(String name, int damage, int hp, int missRate) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.missRate = missRate;
    }

    int decreaseHp(int damage){

        this.hp -= damage;
        return this.hp;
    }

    void hit(Boxer boxer){
        Random r = new Random();
        this.missRate = r.nextInt(100);
        if(boxer.missRate > 50){
            System.out.println(this.name + " Đã đánh hụt " + boxer.name);

            System.out.println(this.name + " Miss : " + this.missRate);
            System.out.println(boxer.name + " Miss : " + boxer.missRate);
        }else{
            boxer.decreaseHp(this.damage);
            System.out.println(this.name + "HP : "+ this.hp + " Miss : "+this.missRate );
            System.out.println(boxer.name + "HP : "+ boxer.hp + " Miss : "+boxer.missRate);
        }
    }
}
