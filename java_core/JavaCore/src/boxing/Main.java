package boxing;

public class Main {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("BillGate",10,100,40);
        Boxer boxer2 = new Boxer("Biladen",15,100,40);
        int round = 1 ;
        if(boxer1.damage > boxer2.damage){
            round = 2;
        }else{
            round = 1;
        }

        while(boxer1.hp > 0 && boxer2.hp > 0 ){
            if(round % 2 == 0){
                boxer2.hit(boxer1);
            }else{
                boxer1.hit(boxer2);
            }
            round++;
        }

    }
}
