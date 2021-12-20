package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

public class LogUtil {
    private Logger logger ;
    private String CLASS_NAME ;
    public LogUtil(String currentClassName){
        System.out.println(currentClassName);
        this.CLASS_NAME = currentClassName;
        this.logger = LogManager.getLogger(currentClassName);//Log4j

    }

    public void ShowSessionInfo(HttpSession session){
        for(int i =0;i<session.getValueNames().length;i++){
            this.logger.info("Session Field :"+session.getValueNames()[i]+";value :"+session.getAttribute(session.getValueNames()[i]));
        }

    }
}
