package exercise.homework3;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<BillVietNam> billVietNamList = new ArrayList<>();
    private List<BillForeign> billForeignList = new ArrayList<>();


    public void sumBill(){
        System.out.println("Số hóa đơn tiền điện ở VN là :" + billVietNamList.size());
        System.out.println("Số hóa đơn tiền điện ở nước ngoài là :" + billForeignList.size() );
    }

    public void sumForeign(){
        float sum = 0;
        for( BillForeign b : billForeignList){
            sum += b.getNumber() * b.getUnit();
        }
        System.out.println("Tổng số tiền điện của khách nước ngoài là : " +sum);
    }

    public List<BillVietNam> getBillVietNamList() {
        return billVietNamList;
    }

    public void setBillVietNamList(List<BillVietNam> billVietNamList) {
        this.billVietNamList = billVietNamList;
    }

    public List<BillForeign> getBillForeignList() {
        return billForeignList;
    }

    public void setBillForeignList(List<BillForeign> billForeignList) {
        this.billForeignList = billForeignList;
    }
}
