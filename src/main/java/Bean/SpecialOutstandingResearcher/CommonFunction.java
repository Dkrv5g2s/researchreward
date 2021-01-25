package Bean.SpecialOutstandingResearcher;

public class CommonFunction {
    /*將string頭跟尾空白全部清除*/
    public static String setString(String Pvalue) {
        return (Pvalue == null) ? "" : Pvalue.trim();
    }

    public static Integer setInt(String pString,Integer defaultValue) {
        try{
            return Integer.parseInt(pString);
        }
        catch(Exception e){}
        return defaultValue;
    }
}
