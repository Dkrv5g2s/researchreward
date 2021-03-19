package Utils.verifyDuplicatePaper;

import Bean.SpecialOutstandingResearcher.CommonFunction;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class VerifyUtils {
    private LevenshteinDistanceAlgo LDAlgo = new LevenshteinDistanceAlgo();
    private final double defaultSimilarityRate = 0.95; // 相似度程度
    private Logger logger = Logger.getLogger(this.getClass());

    public boolean isPaperReapplied(String inputPaperToken ,List<String> totalPaperTitleList){
        // use Book_name + Scholarly_journals_name as similarity token
        String inputPaperSentenceSpaceRemoved = removeSpace(inputPaperToken)  ;
        boolean isPaperReappliedResult = false;
        ListIterator<String> it = totalPaperTitleList.listIterator();

        while (it.hasNext()) {
            String dbPaperSentence = it.next();
            double similarityRate = LDAlgo.getNormalizedSimilarity(inputPaperSentenceSpaceRemoved,removeSpace(dbPaperSentence));
            this.logger.debug("similarityRate :"+ similarityRate);
            if(isSimilarityRateOverStandard(similarityRate)) {
                this.logger.debug("Rate over 95%:"+ dbPaperSentence);
                isPaperReappliedResult = true;
                break;
            }
        }

        this.logger.debug("isPaperReappliedResult:"+ isPaperReappliedResult);
        return isPaperReappliedResult;

    }
    private boolean isSimilarityRateOverStandard(double similarityRate){

        if(Double.compare(similarityRate,this.defaultSimilarityRate)>=0){
            // >95%
//            System.out.println("similarityRate over 95%:"+similarityRate); //demo用
            return true;
        }
        else
            return false;
    }

    private String removeSpace(String input ){
        return input.replaceAll("\\s+", "");
    }


}


