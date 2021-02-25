package Utils.verifyDuplicatePaper;

import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class VerifyUtils {
    private LevenshteinDistanceAlgo LDAlgo = new LevenshteinDistanceAlgo();
    private final double defaultSimilarityRate = 0.95; // 相似度程度

    public boolean isPaperReapplied(String inputPaperToken ,List<String> totalPaperTitleList){
        // use Book_name + Scholarly_journals_name as similarity token
        String inputPaperSentenceSpaceRemoved = removeSpace(inputPaperToken)  ;
        boolean verificationResult = false;
        ListIterator<String> it = totalPaperTitleList.listIterator();

        while (it.hasNext()) {
            String dbPaperSentence = it.next();
            double similarityRate = LDAlgo.getNormalizedSimilarity(inputPaperSentenceSpaceRemoved,removeSpace(dbPaperSentence));
            if(isSimilarityRateOverStandard(similarityRate)) {
                verificationResult = true;
                break;
            }
        }
        return verificationResult;

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


