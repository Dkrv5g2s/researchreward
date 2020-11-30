package Utils;

import java.io.*;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DocxToPdfUtil {

    private static final int wdFormatPDF = 17;

    public static void wordToPDF(String inputFileName, String outputFileName) {

        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        Dispatch doc = null;

        try{
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));
            Dispatch docs = app.getProperty("Documents").toDispatch();
            doc = Dispatch.call(docs, "Open", inputFileName).toDispatch();

            File outputFile = new File(outputFileName);
            if (outputFile.exists()) {
                outputFile.delete();
            }
            Dispatch.call(doc,"SaveAs",outputFileName,wdFormatPDF);
            long end = System.currentTimeMillis();

            }
        catch(Exception e){

        }
        finally{
            Dispatch.call(doc,"Close",false);

            if(app!=null)
                app.invoke("Quit",new Variant[]{});
        }
        ComThread.Release();
    }

}
