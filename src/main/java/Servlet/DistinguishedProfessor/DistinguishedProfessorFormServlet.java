package Servlet.DistinguishedProfessor;

import Service.DistinguishedProfessor.DistinguishedProfessorFormService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;

import java.io.IOException;

public class DistinguishedProfessorFormServlet extends ServletEntryPoint {

	private DistinguishedProfessorFormService distinguishedProfessorFormService = new DistinguishedProfessorFormService();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getForm(req);
		
		req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorForm.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if((String)session.getAttribute("userNumber") != "") {
        	getForm(req);
        }
        
        String jsonString = readJSONString(req);
        
        if(!jsonString.equals("")) {
        	JSONObject json = new JSONObject(jsonString);
            distinguishedProfessorFormService.save(json,(String)session.getAttribute("userNumber"));

            req.getRequestDispatcher("/DistinguishedProfessorAppDocInstructions.jsp").forward(req, resp);
        }
        else {
        	req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorForm.jsp").forward(req, resp);
        }
        
    }
    
    private void getForm(HttpServletRequest req) {
    	HttpSession session = req.getSession();

    	DistinguishedProfessorForm distinguishedProfessorForm = distinguishedProfessorFormService.show((String)session.getAttribute("userNumber"));
		
    	req.setAttribute("usernum", (String)session.getAttribute("userNumber"));
    	
    	if(distinguishedProfessorForm!=null) {			
			req.setAttribute("name", distinguishedProfessorForm.getName());
			req.setAttribute("department",distinguishedProfessorForm.getDepartment());
			req.setAttribute("hireddate",distinguishedProfessorForm.getHireddate());
			req.setAttribute("certificatenum",distinguishedProfessorForm.getCertificatenum());
			req.setAttribute("upgradedate", distinguishedProfessorForm.getUpgradedate());
			req.setAttribute("seniority", distinguishedProfessorForm.getSeniority());
			req.setAttribute("email", distinguishedProfessorForm.getEmail());
			req.setAttribute("researchroomext", distinguishedProfessorForm.getResearchroomext());
			req.setAttribute("cellphone", distinguishedProfessorForm.getCellphone());
			if(distinguishedProfessorForm.getApplicationrequirements1()){
				req.setAttribute("applicationrequirements1","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements2()){
				req.setAttribute("applicationrequirements2","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements3()){
				req.setAttribute("applicationrequirements3","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements4()){
				req.setAttribute("applicationrequirements4","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements5()){
				req.setAttribute("applicationrequirements5","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements6()){
				req.setAttribute("applicationrequirements6","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements7()){
				req.setAttribute("applicationrequirements7","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements8()){
				req.setAttribute("applicationrequirements8","checked");
			}
			if(distinguishedProfessorForm.getApplicationrequirements9()){
				req.setAttribute("applicationrequirements9","checked");
			}
		}
    }
    
}