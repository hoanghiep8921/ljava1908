package exercise.homework2;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        //kiểm tra năm không hợp lệ
        if (year < 0) {
            System.out.println("Năm không hợp lệ");
            return;
        }
        //kiểm tra tháng không hợp lệ
        if (month < 1 || month > 12) {
            System.out.println("Tháng không hợp lệ");
            return;
        }
        //kiểm tra ngày của tháng 2 năm nhuận không hợp lệ
        if (month == 2 && isLeapYear(year)) {
            if (day < 1 || day > 29) {
                System.out.println("Năm nhuận tháng 2 ngày bắt đầu từ 1 -> 29 ");
                return;
            }
        }

        //kiểm tra ngày của tháng 2 không hợp lệ
        if(month == 2 && !isLeapYear(year)){
            if(day < 1 || day > 28){
                System.out.println("Tháng 2 ngày chỉ bắt đầu từ 1 -> 28 ");
                return;
            }
        }
        //kiểm tra ngày trong các tháng
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
                month == 10 || month == 12){
            if(day < 1 || day > 31){
                System.out.println("Ngày trong tháng " +month + " không hợp lệ");
                return;
            }
        }else{
            if(day < 1 || day > 30){
                System.out.println("Ngày trong tháng " +month + " không hợp lệ");
                return;
            }
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            return true;
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
