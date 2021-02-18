package Servlet.OutstandingResearchAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OutstandingResearchAwardCatalogServlet extends ServletEntryPoint {
    private static final String Catalog_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardCatalog.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        // 為了給表B上傳的
//        int project_id = turnIdInSessionToInt(session, "projectId");
//        int user_number = turnIdInSessionToInt(session, "userNumber");
//        Boolean readonly = false ;//TODO role判斷
        // 但另一個問題 在修改申請獎項 點獎項>修改時，project_id應該是已經被設定進session內，那這樣存活多久?

//        session.setAttribute( "project_id", project_id );
//        session.setAttribute( "readonly", readonly );
        System.out.println("OutstandingResearchAwardCatalogServlet");
        ShowSessionValue(session);
        req.getRequestDispatcher(Catalog_URL).forward(req,resp);
    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
    private void ShowSessionValue(HttpSession session){
        for(int i =0;i<session.getValueNames().length;i++)
            System.out.println("Key:"+session.getValueNames()[i]+"value:"+session.getAttribute(session.getValueNames()[i]));
    }
}
