package Servlet.File;

import Bean.SpecialOutstandingResearcher.CommonFunction;
import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import Utils.ItextPdfElementTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

public class FileServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            //doPost(req, resp);
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    // GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItextPdfElementTool.setFontFilePath(this.getServletContext().getRealPath("") + "/font/kaiu.ttf"); //設定字體檔案路徑
        request.setCharacterEncoding("UTF-8"); // Ajax need
        String func = (String) request.getParameter("func"); // 功能名稱
        func = CommonFunction.setString(func);

        // 收集資料
        HttpSession session = request.getSession();         // 取得 session 物件
        //UserData ud = (UserData)session.getAttribute("ud"); // 取得 session 中的物件


        String filePath = ""; //檔案位置
        String fileName = ""; //檔案名稱

        if (func.toLowerCase().equals("joint_authorization_agreement".toLowerCase())) { //如果fun是sci_paper則透過資料庫查詢相關的位置
            try {
                int paper_id = Integer.parseInt(request.getParameter("id"));

                PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl();

                PaperPerformance paperPerformance = dao.query_specified_paper_performance(paper_id);

                if (!CommonFunction.setString(paperPerformance.getJoint_authorization_agreement_file_path()).equals("")) {
                    //filePath = this.getServletContext().getRealPath("/")+""WEB-INF\\uploadFile\\"+paperPerformance.getJoint_authorization_agreement_file_path();
                    filePath = "C:\\apache-tomcat-8.5.55\\webapps\\RRS_uploadFile\\" + paperPerformance.getJoint_authorization_agreement_file_path();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (func.toLowerCase().equals("paper_home".toLowerCase())) { //如果fun是sci_paper則透過資料庫查詢相關的位置
            try {
                int paper_id = Integer.parseInt(request.getParameter("id"));

                PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl();

                PaperPerformance paperPerformance = dao.query_specified_paper_performance(paper_id);

                if (!CommonFunction.setString(paperPerformance.getPaper_home_file_path()).equals("")) {
                    //filePath = this.getServletContext().getRealPath("/")+""WEB-INF\\uploadFile\\"+paperPerformance.getPaper_home_file_path();
                    filePath = "C:\\apache-tomcat-8.5.55\\webapps\\RRS_uploadFile\\" + paperPerformance.getPaper_home_file_path();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /*開始進行資料寫給使用者*/
        InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        if (!fileName.equals(""))
            response.setHeader("Content-Disposition", "inline; filename=\"" + java.net.URLEncoder.encode(fileName, "UTF-8") + "\"");
        response.setContentType("application/pdf;");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();

        //只要是有在這個List中的func 表示這是臨時產生的申請PDF 產生的檔案都會刪除
        ArrayList<String> generArrayList = new ArrayList<String>();
        generArrayList.add("generatePDF".toLowerCase());
        generArrayList.add("generateGrantProjectListPDF".toLowerCase());
        if (generArrayList.contains(func.toLowerCase())) {
            if (new File(filePath).exists()) {
                new File(filePath).delete();
            }
        }
    }
}


