package exercise;

import exercise.homework1.Account;
import exercise.homework2.Date;
import exercise.homework3.BillForeign;
import exercise.homework3.BillVietNam;
import exercise.homework3.Customer;
import exercise.homework3.Repository;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Account accountA = new Account("JV",1,0.0);
        Account accountB = new Account("Hiep",2,0.0);

        accountA.credit(5000);
        accountB.credit(3000);

        //accountA.credit(-1000);

        accountA.debit(10000);
        accountA.debit(-1000);
        accountA.debit(3000);

        System.out.println("____");
        accountA.transferTo(accountB,2000);

        System.out.println("_____");
        Date now = new Date(-12,12,2019);
        System.out.println(now.toString());

        System.out.println("____________");
        Date d = new Date(1,2,2019);
        Customer customer = new Customer(50,3000.0f,200,"Sinh hoạt");
        BillVietNam vn = new BillVietNam("01","HIEP",d,customer);

        BillForeign foreign = new BillForeign("DH02",
                "John Wick",new Date(2,2,2019),"US",100,5000);
        //tạo kho
        Repository repository = new Repository();
        //tính tổng
        repository.sumBill();
        System.out.println("____Begin add bill____");
        //lấy ra danh sách bill trong kho
        List<BillVietNam> listBillVN = repository.getBillVietNamList();
        List<BillForeign> listBillFR = repository.getBillForeignList();

        //thêm mới các hóa đơn vào danh sách
        listBillVN.add(vn);
        listBillFR.add(foreign);

        //đặt lại vào trong kho
        repository.setBillVietNamList(listBillVN);
        repository.setBillForeignList(listBillFR);

        repository.sumBill();
        repository.sumForeign();



    }
}
