package Utils;

import fr.opensagres.xdocreport.document.json.JSONObject;

import java.lang.reflect.Field;

public final class ReflectUtils {

    private ReflectUtils(){}

    public static <T> void addBeanPropertyToJson(JSONObject json, T bean) throws IllegalAccessException {
        for (Field field: bean.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.get(bean) == null) {
                json.put(field.getName(), "");
            }else {
                json.put(field.getName(), field.get(bean));
            }
        }
    }
}
