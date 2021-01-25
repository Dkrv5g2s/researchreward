package Utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;

import java.io.IOException;

public class ItextPdfElementTool {
    private static String fontFilePath = "D:/kaiu.ttf"; //字體檔路徑

    //設定字體檔路徑
    public static void setFontFilePath(String s){
        fontFilePath = s;
    }

    //建立表格中的Cell
    public static PdfPCell getStringCell(int colspan, int rowspan, String text, int fontSize, boolean hasBorder, int verticalAlignment, int alignment, int fontStyle){
        PdfPCell cell = new PdfPCell();
        try {
            BaseFont bf = BaseFont.createFont(fontFilePath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );
            Font font = new Font( bf, fontSize, fontStyle );
            cell.setColspan(colspan);
            cell.setRowspan(rowspan);
            cell.setVerticalAlignment(verticalAlignment);
            Paragraph preface = new Paragraph();
            preface.setFont(font);
            preface.setAlignment(alignment);
            preface.add(new Phrase(text));
            cell.addElement(preface);
            cell.setPaddingBottom(8);
            if(!hasBorder)
                cell.setBorder(0);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }

    //建立表格中的Cell
    public static PdfPCell getStringCell(int colspan,int rowspan,String text,int alignment){
        return getStringCell(colspan,rowspan,text,12,true, Element.ALIGN_MIDDLE,alignment,Font.NORMAL);
    }

    /*建立文字Paragraph*/
    public static Paragraph getStringParagraph(String text,int fontSize,int alignment,int fontStyle){
        Paragraph preface = new Paragraph();
        BaseFont bf;
        try {
            bf = BaseFont.createFont(fontFilePath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );
            Font font = new Font( bf, fontSize, fontStyle );
            preface.setFont(font);
            preface.setAlignment(alignment);
            preface.setIndentationRight(0);
            preface.add(new Phrase(text));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return preface;
    }

    //建立表格中的Cell 第一個參數為第一行往左移幾px 第二個參數為每行往右往右偏移幾px
    public static Paragraph setHangingIndent(int n,int n2,Paragraph p){
        p.setFirstLineIndent(-n); //首行凸排
        p.setIndentationLeft(n+n2);
        p.setIndentationRight(0);
        return p;
    }

    //建立表格中的是圖片的Cell
    public static PdfPCell getImageCell(int colspan,int rowspan,String ImagePath){
        PdfPCell cell = new PdfPCell();
        try {
            Image image = Image.getInstance(ImagePath);
            cell.setColspan(colspan);
            cell.setRowspan(rowspan);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.addElement(image);
            cell.setPaddingBottom(8);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return cell;
    }

}
