package scope;

public class Superman {
    public String name;
    public static String address = "Hà nội";
    private Dog dog = new Dog("Shiba",10);

    public void fly(){
        int h = 100;
        System.out.println("Đang bay ở độ cao là :" + h);
    }

}
