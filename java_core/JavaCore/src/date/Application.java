package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date.toString());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,15);
        calendar.set(Calendar.MONTH,10);


        Date d = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(simpleDateFormat.format(d));

        Date d2 = simpleDateFormat.parse("10/10/2019 00:10:10");
        System.out.println(d2);
    }
}
