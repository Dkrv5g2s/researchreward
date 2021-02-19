package Utils.verifyDuplicatePaper;

import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;

import java.util.List;
import java.util.ListIterator;

public class VerifyUtils {
    private PaperPerformanceDescriptionDAO dao ;

    public boolean isInputaDuplicatePaperTitle(String inputPaperTitle){
        String trimmedInputPaperTitle = removeSpace(inputPaperTitle);
        Boolean result = false;

        dao = new PaperPerformanceDescriptionDAOImpl();
        List<String> paper_title_list = dao.query_total_paper_title();
        ListIterator<String> it = paper_title_list.listIterator();
        while (it.hasNext()) {
            String item = removeSpace(it.next());

            if (item.equals(trimmedInputPaperTitle)) {
                //duplicated paper title
                result =  true;
            }
        }

        return result;

    }
    private String removeSpace(String input ){
        return input.replaceAll("\\s+", "");
    }


}


