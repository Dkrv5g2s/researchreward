package Utils.verifyDuplicatePaper;

import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class VerifyUtils {
    public boolean isInputasDuplicatePaperTitle(String inputPaperTitle ,List<String> total_paper_title_list){

        String trimmedInputPaperTitle = removeSpace(inputPaperTitle);
        boolean result = false;

        List<String> paper_title_list = total_paper_title_list.stream().collect(Collectors.toList());//copy the list

        ListIterator<String> it = paper_title_list.listIterator();

        while (it.hasNext()) {
            String item = it.next();
            if (trimmedInputPaperTitle.equals(removeSpace(item))) {
                //the new paper title is a duplicated paper title
                result =  true;
                break;
            }
        }
        return result;

    }
    private String removeSpace(String input ){
        return input.replaceAll("\\s+", "");
    }


}


