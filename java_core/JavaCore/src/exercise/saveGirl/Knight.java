package exercise.saveGirl;

public class Knight extends Character {
    private int armor = Constant.ARMOR_KNIGHT;

    public int totalDame(){
        return this.damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void decreaseHp(int dame){
        this.hp -= dame*0.7;
        System.out.println("Máu hiện tại của nhân vật là : "+this.hp);
    }
}
