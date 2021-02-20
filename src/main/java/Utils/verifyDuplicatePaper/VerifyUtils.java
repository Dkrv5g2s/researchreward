package Utils.verifyDuplicatePaper;

import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class VerifyUtils {
    public String getDuplicatePaperTitle(String inputPaperTitle ,List<String> totalPaperTitleList){
        String trimmedInputPaperTitle = removeSpace(inputPaperTitle);
        String duplicatePaperTitle = "";

        ListIterator<String> it = totalPaperTitleList.listIterator();

        while (it.hasNext()) {
            String paperTitle = it.next();
            if (trimmedInputPaperTitle.equals(removeSpace(paperTitle))) {
                duplicatePaperTitle = paperTitle;
                break;
            }
        }
        return duplicatePaperTitle;

    }
    private String removeSpace(String input ){
        return input.replaceAll("\\s+", "");
    }


}


