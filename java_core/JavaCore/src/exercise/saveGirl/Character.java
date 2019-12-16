package exercise.saveGirl;

public class Character {
    protected int hp = 500;
    //lượng sát thương gây ra
    protected int damage = Constant.DAME_NORMAL;
    protected int mana = 100;

    public void regen(int totalDamage){
        if(this.mana < Constant.MANA_SKILL_REGEN){
            System.out.println("Không đủ mana để hồi máu");
            return;
        }
        this.hp += totalDamage;
        if(hp > Constant.MAX_HP){
            this.hp = Constant.MAX_HP;
        }
        this.mana -= 10;
        System.out.println("Máu hiện tại của nhân vật là " + this.hp);
        System.out.println("Mana hiện tại của nhân vật là " + this.mana);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
