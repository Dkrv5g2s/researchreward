package Utils;

import java.io.*;
import java.nio.charset.Charset;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;


import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxToPdfUtil {

    private static final int wdFormatPDF = 17;



    public static void wordToPDF(String inputFileName, String outputFileName) {
        try {
            parseHtmlToPdf(docx2Html(inputFileName),outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseHtmlToPdf(String content, String pdfPath) throws Exception {

        // 創建一個document對象實例
        Document document = new Document();
        // 爲該Document創建一個Writer實例
        PdfWriter pdfwriter = PdfWriter.getInstance(document,
                new FileOutputStream(pdfPath));
        pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
        // 打開當前的document
        document.open();

        FontProvider fontProvider = new FontProvider() {
            @Override
            public boolean isRegistered(String fontname) {
                return true;
            }

            @Override
            public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
                Font font = null;
                try {
                    font = new Font(BaseFont.createFont("/font/kaiu.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED),size,style,color);
                    font.setColor(color);

                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return font;
            }
        };
        System.out.println(content.getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, new ByteArrayInputStream(content.getBytes()), Charset.forName("UTF-8"),fontProvider);
        XMLWorkerFontProvider
        document.close();
    }
    private static String docx2Html(String docxPath) throws IOException {

        String content = null;
        InputStream in = new FileInputStream(new File(docxPath));
        XWPFDocument document = new XWPFDocument(in);

        XHTMLOptions options = XHTMLOptions.create();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XHTMLConverter.getInstance().convert(document, baos, options);
        baos.close();
        content = baos.toString();

        System.out.println( content);
        return content;
    }

}
