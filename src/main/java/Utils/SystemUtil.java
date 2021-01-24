package Utils;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SystemUtil {
    // constructor
    public SystemUtil() {}


    // 從Servlet中轉往指定的View(JSP)
    // pViewPath: View(JSP)檔案的路徑
    public static void forward(String pViewPath, HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException, ServletException {
        PrintWriter pw = null;
        RequestDispatcher rd = null;
        try {
            rd = pRequest.getRequestDispatcher(pViewPath);
            rd.forward(pRequest, pResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
            pw = pResponse.getWriter();
            pw.println("File Not Found Or No Permission.");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static void generateDatasExcel(String filePath,ArrayList<String> titles,ArrayList<String[]> datasList) throws Exception{
        FileOutputStream fileOut = new FileOutputStream(filePath); // 新建一輸出檔案流
        HSSFWorkbook workBook = new HSSFWorkbook(); // 在Excel中建一工作表
        HSSFSheet sheet = workBook.createSheet("輔導活動");
        int i = 0,index = 0;
        HSSFRow rowForTitle = sheet.createRow(index++);
        for(i=0;i<titles.size();i++){
            rowForTitle.createCell(i).setCellValue(titles.get(i));
        }
        for(i=0;i<datasList.size();i++){
            rowForTitle = sheet.createRow(index++);
            for(int j=0;j<datasList.get(i).length;j++){
                rowForTitle.createCell(j).setCellValue(datasList.get(i)[j]);
            }
        }
        workBook.write(fileOut); // 把相應的Excel存檔
        fileOut.flush();
        fileOut.close(); // 操作結束，關閉檔
    }

    //讓網頁下載檔案 filePath=>檔案位置   downloadFileName=>下載時地的檔案名
    public static void downloadFile(HttpServletResponse response,String filePath,String downloadFileName) throws Exception{
        BufferedInputStream fis = new BufferedInputStream( new  FileInputStream(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        BufferedOutputStream toClient = new  BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/force-download");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Disposition","attachment; filename=\"" + downloadFileName + "\"");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    /* 幫post的是enctype="multipart/form-data" 將資料整理到Map中*/
    public static void uploadRequestDataToMap(HttpServletRequest request,TreeMap<String,String> parameterMap,TreeMap<String,FileItem> fileMap) throws Exception {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = upload.parseRequest(request);
        for(int i=0;i<items.size();i++) {//將post中所有欄位進行塞選
            FileItem item = (FileItem) items.get(i);
            if (item.isFormField()) {// Form的區域 (非檔案區域)
                String name = item.getFieldName();
                String value = item.getString("UTF-8");
                parameterMap.put(name, value);
            } else {  // 非form區域(檔案區域)
                String name = item.getFieldName();
                fileMap.put(name, item);
            }
        }
    }
}
