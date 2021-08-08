package Utils;

import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
    public String getNowDate(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(date);
    }

    public static java.sql.Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new java.sql.Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}