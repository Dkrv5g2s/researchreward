package Utils;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {


        RewardFormDocument document = new RewardFormDocument("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.docx");
        document.writeContentInTable(0,0,1,"老王");
        document.close();

        try {
            DocxToPdfUtil.wordToPDF("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.docx","C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
