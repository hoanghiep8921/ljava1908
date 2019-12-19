package exercise.saveGirl;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        Magical magical = new Magical();

        int round = 0;
        while (dragon.getHp() > 0 && magical.getHp() > 0){
            System.out.println();
            System.out.println("___Hiệp đấu thứ " + round);
            if(round % 2 == 0){
                int trueDame = magical.totalDame(dragon);
                System.out.println("Lượng sát thương gây ra cho RỒng là "+ trueDame);
                dragon.decreaseHP(trueDame,Constant.DAME_PHYSICAL);
            }else{
                int trueDame = dragon.totalDamage();
                System.out.println("Lượng sát thương gây ra cho Pháp sư là "+ trueDame);
                magical.decreaseHp(trueDame);
            }
            round++;
        }

        if(magical.getHp() > 0){
            System.out.println("Cứu được người đẹp");
        }else{
            System.out.println("Bạn đã hy sinh");
        }
    }
}
