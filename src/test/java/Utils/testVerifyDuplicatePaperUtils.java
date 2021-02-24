package Utils;
import Utils.verifyDuplicatePaper.LevenshteinDistanceAlgo;
import Utils.verifyDuplicatePaper.SimilarityAlgo;
import Utils.verifyDuplicatePaper.VerifyUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class testVerifyDuplicatePaperUtils {
    private VerifyUtils verifyUtils;
    private List<String> totalPaperTitleList;
    @Before
    public void setUp(){
        verifyUtils = new VerifyUtils();
        totalPaperTitleList = new ArrayList<>();
        totalPaperTitleList.add("貓熊的生存難題:肥胖或飢餓");
        totalPaperTitleList.add("從ERDs到跨維度查詢之推薦－以維度資料地圖為指引");
        totalPaperTitleList.add("流行音樂中的「台灣性」——以玖壹壹、陳綺貞與老王樂隊為例");
        totalPaperTitleList.add("Information and Communications Technology Supply Chain Risk Management Task ForceCybersecurity and Infrastructure Security Agency");
        totalPaperTitleList.add("5G Security: Analysis of Threats and Solutions2017 IEEE Conference on Standards for Communications and Networking");
        totalPaperTitleList.add("5G mobile telecommunication network-Technical requirement of 5G security");
        totalPaperTitleList.add("以深度學習方法預測大型活動對臺北捷運運量之影響");
    }

    @Test
    public void TestEuclideanAlgo(){
        SimilarityAlgo eAlgo = new SimilarityAlgo();
        double[] vector1= {1,0};
        double[] vector2= {0,1};
        System.out.println(eAlgo.getEuclideanSimilarity(vector1,vector2));
        System.out.println(eAlgo.getCosineSimilarity(vector1,vector2));
    }

    @Test
    public void TestLevenshteinDistanceSimilarity(){
        // 比對 論文名稱 + 期刊名稱
        //totally same
        String reappliedWord = "以深度學習方法預測大型活動對臺北捷運運量之影響";
        String reappliedPaper1 = "5G Security: Analysis of Threats and Solutions2017 IEEE Conference on Standards for Communications and Networking";
        String reappliedPaper1WithTotalChinese = "流行音樂中的「台灣性」——以玖壹壹、陳綺貞與老王樂隊為例";
        String reappliedPaper1WithTotalEnglish = "Information and Communications Technology Supply Chain Risk Management Task ForceCybersecurity and Infrastructure Security Agency";
        String reappliedPaper1WithMixedWords = "從ERDs到跨維度查詢之推薦－以維度資料地圖為指引";
        //over 95 %
        String reappliedWordOver95Persent = "以深度學習方法預測大型活動對新北捷運運量之影響";
        String reappliedPaper1Over95Persent = "5G Security:Analysiss of Threats and Solutions2017 IEEE Conference on Standards for Communications and Networking";
        String reappliedPaper1WithTotalChineseOver95Persent = "流行音樂中的「台灣性」——以玖壹壹、陳綺貞與老王樂隊為例子";
        String reappliedPaper1WithTotalEnglishOver95Persent = "Informations and Communications Technology Supply Chain Risk Management Tasks ForceCybersecurity and Infrastructure Security Agency";
        String reappliedPaper1WithMixedWordsOver95Persent = "從ERDXs到跨維度查詢之推薦－以維度資料地圖為指引";

        //Less than 95 %
        String reappliedWordLessThan95Persent = "以深度學習方法預測超級大型活動對臺北捷運人潮運量之影響";
        String reappliedPaper1LessThan95Persent = "4G Security:Analysiss of Threats and Solutijonss in Internet2015 IEEE Conferencee on Standards for Communications and Networking";
        String reappliedPaper1WithTotalChineseLessThan95Persent = "流行音樂中的「性隱喻」——以美秀集團、熱狗與頑童為例子";
        String reappliedPaper1WithTotalEnglishLessThan95Persent = "CISA 5G StrategyCybersecurity and Infrastructure Security Agency";
        String reappliedPaper1WithMixedWordsLessThan95Persent = "從空污到遷村：大林蒲的大氣海洋政治";



        //totally same
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedWord,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalChinese,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalEnglish,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithMixedWords,totalPaperTitleList));
        // over 95 %
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedWordOver95Persent,totalPaperTitleList));//0.956
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1Over95Persent,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalChineseOver95Persent,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalEnglishOver95Persent,totalPaperTitleList));
        Assert.assertTrue( verifyUtils.isPaperReapplied(reappliedPaper1WithMixedWordsOver95Persent,totalPaperTitleList));
        // less than 95%
        Assert.assertFalse( verifyUtils.isPaperReapplied(reappliedWordLessThan95Persent,totalPaperTitleList));
        Assert.assertFalse( verifyUtils.isPaperReapplied(reappliedPaper1LessThan95Persent,totalPaperTitleList));
        Assert.assertFalse( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalChineseLessThan95Persent,totalPaperTitleList));
        Assert.assertFalse( verifyUtils.isPaperReapplied(reappliedPaper1WithTotalEnglishLessThan95Persent,totalPaperTitleList));
        Assert.assertFalse( verifyUtils.isPaperReapplied(reappliedPaper1WithMixedWordsLessThan95Persent,totalPaperTitleList));

    }






}
