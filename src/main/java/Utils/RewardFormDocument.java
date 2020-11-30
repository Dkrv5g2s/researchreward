package Utils;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RewardFormDocument {
    private XWPFDocument document;


    public RewardFormDocument(String filePath) throws IOException {
        this.document = new XWPFDocument(new FileInputStream(filePath));
    }

    public void writeContentInTable(int tableIndex, int row, int column,String content){
        XWPFTable x = document.getTables().get(tableIndex);

        x.getRow(row).getCell(column).removeParagraph(0);
        XWPFParagraph a = x.getRow(row).getCell(column).addParagraph();
        a.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun c = a.createRun();
        c.setFontFamily("標楷體");
        c.setText(content);
        c.setFontSize(14);
        a.addRun(c);
    }


    public void saveFile(String filePath) throws IOException {
        document.write(new FileOutputStream(filePath));
    }

    public void close() throws IOException {
        this.document.close();
    }

}
