package exercise.homework1;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account(String name,int customer,double balance){
        this.name = name;
        id = customer;
        this.balance = balance;
    }

    public Account(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void credit(int amount){
        if(amount < 0){
            System.out.println("Số tiền không hợp lệ");
            return;
        }
        this.setBalance(this.getBalance() + amount);
        System.out.println("Số dư của tài khoản " + this.name + " là : " + balance);
    }

    public void debit(int amount){
        if(amount < 0 || amount > this.balance){
            System.out.println("Số tiền không hợp lệ");
            return;
        }
        this.setBalance(getBalance() - amount);
        System.out.println("Số dư của tài khoản " + this.name + " là : " + balance);
    }

    public void transferTo(Account account,int amount){
        if(amount < 0 || amount > this.balance) {
            System.out.println("Số tiền muốn chuyển không hợp lệ");
            return;
        }
        this.setBalance(getBalance() - amount);
        account.setBalance(account.getBalance() + amount);
        System.out.println("Số dư của tài khoản " + this.name + " là : " + balance);
        System.out.println("Số dư của tài khoản " + account.getName() + " là : " + account.getBalance());
    }


}
