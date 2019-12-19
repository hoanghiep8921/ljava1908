package exercise.saveGirl;

public class Dragon {
    private int hp = 1000;
    private int armor = 30; //%
    private int antiMagical = 20; //%
    private int crit = 20; //%
    private int damage = 100;

    public int totalDamage(){
        int number = Constant.random.nextInt(100);
        if(number < 20){
            return this.damage*2;
        }else{
            return this.damage;
        }
    }
    public void decreaseHP(int damage,int type){
        int trueDame;
        if(type == Constant.DAME_PHYSICAL){
            trueDame = (int)(damage*0.7);
        }else{
            trueDame = (int)(damage*0.8);
        }
        this.hp -= trueDame;
        System.out.println("Máu hiện tại của Rồng NAMEX là : " + this.hp);
    }

//    public void decreaseHPMagical(int damageMagical){
//        int trueDame = (int)(damageMagical*0.8);
//        this.hp -= trueDame;
//    }
//
//    public void decreaseHPPhysical(int damagePhysical){
//        int trueDame = (int)(damagePhysical*0.7);
//        this.hp -= trueDame;
//    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAntiMagical() {
        return antiMagical;
    }

    public void setAntiMagical(int antiMagical) {
        this.antiMagical = antiMagical;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
