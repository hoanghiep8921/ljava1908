package exercise.saveGirl;

public class Magical extends Character {

    public int totalDame(Dragon dragon){
        int rateShowSkill = Constant.random.nextInt(100);
        int rateRegen = Constant.random.nextInt(100);
        //check sử dụng skill
        if(rateShowSkill < 50){
            //check regen hp
            if(rateRegen < 50){
                System.out.println("Bạn đã được hồi máu");
                int trueDame = (int)(dragon.getHp()/2*0.8);
                regen(trueDame);
            }
            thunder(dragon);
            return 0;

            //check đánh thường
        }else{
            return this.damage;
        }
    }

    public void thunder(Dragon dragon){
        if(this.mana < Constant.MANA_SKILL_THUNDER){
            System.out.println("Không đủ mana để triệu hồi sấm sét");
            return ;
        }
        System.out.println("Triệu hồi sấm sét vào rồng NAMEX");
        dragon.decreaseHP(dragon.getHp()/2 , Constant.DAME_MAGICAL);
    }

    public void decreaseHp(int dame){
        this.hp -= dame;
        System.out.println("Máu hiện tại của nhân vật là : "+this.hp);
    }
}
