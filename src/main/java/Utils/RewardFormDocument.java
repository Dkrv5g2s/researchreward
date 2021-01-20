package Utils;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RewardFormDocument {
    private XWPFDocument document;


    public RewardFormDocument(String filePath) throws IOException {
        this.document = new XWPFDocument(new FileInputStream(filePath));
    }



    public void setContentInTableCell(int tableIndex, int row, int column,String content){
        XWPFTable x = document.getTables().get(tableIndex);
        x.getRow(row).getCell(column).removeParagraph(0);
        addParagraph(row, column, content, x);
    }

    public void addContentInTableCell(int tableIndex, int row, int column,String content){
        XWPFTable x = document.getTables().get(tableIndex);
        addParagraph(row, column, content, x);
    }

    public void getContentInTableCell(int tableIndex, int row, int column){
        XWPFTable x = document.getTables().get(tableIndex);
        List<XWPFParagraph> a = x.getRow(row).getCell(column).getParagraphs();
        for(XWPFParagraph obj : a){
            System.out.println("1");
            System.out.println(obj.getText());
        }
    }

    public void removeParagraph(int tableIndex, int row, int column,int paragraph){
        XWPFTable x = document.getTables().get(tableIndex);
        x.getRow(row).getCell(column).removeParagraph(paragraph);
    }

    private void addParagraph(int row, int column, String content, XWPFTable x) {
        XWPFParagraph a = x.getRow(row).getCell(column).addParagraph();
        XWPFRun c = a.createRun();
        c.setFontFamily("標楷體");
        c.setText(content);
        c.setFontSize(12);
        a.addRun(c);
    }

    public void addRow(int tableIndex, int rowIndex){
        XWPFTable x = document.getTables().get(tableIndex);
        XWPFTableRow row = x.insertNewTableRow(rowIndex);
        for(int i=0; i<x.getRow(0).getTableICells().size();i++){
            row.addNewTableCell();
        }
    }


    public void appendContentInTableCell(int tableIndex, int row, int column,String content){
        XWPFTable x = document.getTables().get(tableIndex);
        addParagraph(row, column, content, x);
    }


    public void saveFile(String filePath) throws IOException {
        document.write(new FileOutputStream(filePath));
    }

    public void close() throws IOException {
        this.document.close();
    }

}
