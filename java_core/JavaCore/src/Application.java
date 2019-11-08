public class Application {

    public static void main(String[] args) {
        System.out.println("Hello word");
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a+b);
        sum(100,200); //300
        //int c = sum(100,200);
        System.out.println(sum(100,200));
        printDate(3);
    }

    public static boolean checkPrime(int number){
        if(number <= 0 ){
            return false;
        }
        if(number <= 2){
            return true;
        }

        for(int i = 2; i < Math.sqrt(number) ; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void sumPrime(){
        int tong = 0;
        for(int i = 0;i<=100;i++){
            if(checkPrime(i)){
                tong += i;
            }
        }
        System.out.println(tong);
    }

    public static void findNumber(int a){

        if(a % 6 == 0){
            System.out.println("Chia hết cho 6");
            return;
        }

        if(a % 3 == 0){
            System.out.println("Chia hết cho 3");
            return;
        }

        if(a % 2 == 0){
            System.out.println("Chia hết cho 2");
            return;
        }
    }

    public static void printDate(int date){
        switch(date) {
            case 2:
                System.out.println("Thứ 2");
                break;
            case 3:
                System.out.println("Thứ 3");
                break;
            case 4:
                System.out.println("Thứ 4");
                break;
            case 5:
                System.out.println("Thứ 5");
                break;
            case 6:
                System.out.println("Thứ 6");
                break;
            case 7:
                System.out.println("Thứ 7");
                //break;
            case 8:
                System.out.println("Chủ nhật");
                break;
            default:
                System.out.println("Nhập ngày sai rồi");
        }
    }
    public static boolean checkNumber(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }

    public static int sum(int number1, int number2){
        return number1 + number2;
    }

    // Account A => Account B
    public static void transfer(int accountA, int accountB, int money){
        if(accountA < 0 || accountB < 0){
            return ;
        }

        if(money < 0 && money > accountA){
            return ;
        }
        accountA -= money; //accountA = accountA - money
        accountB += money;
        //System.out.println();
    }



}
