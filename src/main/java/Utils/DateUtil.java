package Utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
    public String getNowDate(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(date);
    }
}