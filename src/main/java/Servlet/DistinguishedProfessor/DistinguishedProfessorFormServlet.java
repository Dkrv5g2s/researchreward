package Servlet.DistinguishedProfessor;

import Bean.User.User;
import Service.DistinguishedProfessor.DistinguishedProfessorFormService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class DistinguishedProfessorFormServlet extends ServletEntryPoint {

	private DistinguishedProfessorFormService distinguishedProfessorFormService = new DistinguishedProfessorFormService();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		getForm(req);

        String userRole = session.getAttribute("userRole").toString();
        req.setAttribute("role", userRole);
        req.setAttribute("readonly",session.getAttribute("readonly"));
		req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorForm.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String jsonString = readJSONString(req);
        if(!jsonString.equals("")) {
        	JSONObject json = new JSONObject(jsonString);
            User user = new User();
            user.setStaff_code(session.getAttribute("userNumber").toString());
            user.setRole(session.getAttribute("userRole").toString());
            distinguishedProfessorFormService.save(json, user, session.getAttribute("projectId").toString());
        }
        
    }
    
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
    	HttpSession session = req.getSession();
    	
    	req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",distinguishedProfessorFormService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));		
		
    }
    
}