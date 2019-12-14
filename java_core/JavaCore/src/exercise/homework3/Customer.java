package exercise.homework3;

public class Customer {
    private int number;
    private float unit;
    private int limit;
    private String type;

    public Customer(int number, float unit, int limit, String type) {
        this.number = number;
        this.unit = unit;
        this.limit = limit;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getUnit() {
        return unit;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
