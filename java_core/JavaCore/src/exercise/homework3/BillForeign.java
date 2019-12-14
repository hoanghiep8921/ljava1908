package exercise.homework3;

import exercise.homework2.Date;

public class BillForeign extends Bill {

    private String national;
    private int number;
    private int unit;

    public BillForeign(String id, String name , Date date, String national, int number, int unit) {
        super(id,name,date);
        this.national = national;
        this.number = number;
        this.unit = unit;
    }

    @Override
    public void pay() {
        float sumMoney = this.getNumber() * this.getUnit();
        System.out.println("Số tiền điện của khách hàng " +
                super.getName() + " là : " + sumMoney);
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
