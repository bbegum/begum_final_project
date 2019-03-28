package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static String getTodaysDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        String todaysDate = sdf.format(date);

        return todaysDate;
    }

    public static String  addtoDate(String pattern, int amount){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE,amount); // Adding 5 days
        String output = sdf.format(c.getTime());
        return output;


    }
}