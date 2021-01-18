package Utils;

import java.io.*;
import java.nio.charset.Charset;

import Service.ExcellentResearcher.PDFGenerator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;


import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;
import fr.opensagres.xdocreport.utils.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;


public class DocxToPdfUtil {

    private static final int wdFormatPDF = 17;

    public static void main(String[] args) throws IOException {
        PDFGenerator pdfGenerator = new PDFGenerator();
        pdfGenerator.generateExcellentResearcherPDF("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\excellentResearcher.docx","11101");
        wordToPDF("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\excellentResearcher.docx","C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.pdf");

    }

    public static void wordToPDF(String inputFileName, String outputFileName) {
        try {
            parseHtmlToPdf(refineWidth(docx2Html(inputFileName)),outputFileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseHtmlToPdf(String content, String pdfPath) throws Exception {


        Document document = new Document(PageSize.A4);

        PdfWriter pdfwriter = PdfWriter.getInstance(document,
                new FileOutputStream(pdfPath));
        pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);

        document.open();

        FontProvider fontProvider = new FontProvider() {
            @Override
            public boolean isRegistered(String fontname) {
                System.out.println(fontname);
                return true;
            }

            @Override
            public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
                Font font = null;
                try {
                    System.out.println(fontname);
                    if(fontname == null)
                        return new Font(BaseFont.createFont("/font/mingliu.ttc,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED),size,style,color);
                    switch (fontname){
                        case "新細明體":
                            font = new Font(BaseFont.createFont("/font/kaiu.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED),size,style,color);
                            break;
                        case "標楷體":
                            font = new Font(BaseFont.createFont("/font/mingliu.ttc,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED),size,style,color);
                            break;
                        default:
                            font = new Font(BaseFont.createFont("/font/mingliu.ttc,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED),size,style,color);
                            break;
                    }

                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return font;
            }
        };
        FontFactory.register("/font/mingliu.ttc,1");
        FontFactory.register("/font/kaiu.ttf");

        System.out.println(content);

        System.out.println(content.getBytes().length);

        XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, new ByteArrayInputStream(content.getBytes("UTF-8")), Charset.forName("UTF-8"), fontProvider);
        document.close();
        pdfwriter.close();
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
        document.close();

        return content;
    }

    private static String refineWidth(String content){
        org.jsoup.nodes.Document doc = Jsoup.parse(content);
        org.jsoup.nodes.Element body = doc.body();
        String style = body.attr("style");
//        if (StringUtils.isNotEmpty(style) && style.indexOf("width") != -1){
//            body.attr("style","");
//        }

        org.jsoup.select.Elements divs = doc.select("div");
        for (org.jsoup.nodes.Element div : divs){
            style = div.attr("style");
            System.out.println(style);
            if (StringUtils.isNotEmpty(style) && style.indexOf("width") != -1){
                div.attr("style","");
            }
        }

        //補表格border
        org.jsoup.select.Elements tds = doc.select("td");
        for (org.jsoup.nodes.Element td : tds) {
            System.out.println(td.attr("style"));
            td.attr("style", "border-top:0.5px solid #000000;border-bottom:0.5px solid #000000;border-left:0.5px solid #000000;border-right:0.5px solid #000000;" + td.attr("style"));
        }
        return doc.html();
    }

}
