package exercise.saveGirl;

public class Ranger extends Character {
    public int totalDamage(){
        int number = Constant.random.nextInt(100);
        if(number > 50){
            return this.damage;
        }else{
            return crit();
        }

    }

    public int crit(){
        return totalDamage()*3;
    }
    public void decreaseHp(int dame){
        this.hp -= dame;
        System.out.println("Máu hiện tại của nhân vật là : "+this.hp);
    }
}
