package exception;

public class ExampleException {
    public static void main(String[] args) throws Exception {
        int a = 5;

        sum();

        try {
            System.out.println("Bắt đầu thực hiện phép chia");
//            String b = null;
//            System.out.println(b.length());
            System.out.println("Kết quả của phép chia là :" + a / 1);
            if(a == 5){
                throw new MoneyException("Số tiền không hợp lệ");
            }
        }catch (MoneyException moneyException){
            //ghi logs
            System.out.println(moneyException.getMessage());
        }
        catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Null pointer");
        }
        catch (Exception e){
            System.out.println(" Lỗi Chia cho số 0");
        }
        finally {
            System.out.println("Kết thúc phương thức");
        }

//
//        int i = 0;
//        for(;;){
//            if(i<10){
//                continue;
//            }
//            System.out.println();
//        }


    }
    public static void sum() throws Exception{

        throw new Exception("123");
    }
}
