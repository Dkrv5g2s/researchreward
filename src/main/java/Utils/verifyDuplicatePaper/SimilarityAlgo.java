package Utils.verifyDuplicatePaper;

import java.util.*;

public class SimilarityAlgo {

    public double getEuclideanSimilarity(double[] vectorInInput,double[] vectorInDb) {
        double distance = 0;

        if (vectorInInput.length == vectorInDb.length) {
            for (int i = 0; i < vectorInInput.length; i++) {
                double temp = Math.pow((vectorInInput[i] - vectorInDb[i]), 2);
                distance += temp;
            }
            distance = Math.sqrt(distance);
        }
        return 1.0 / (1.0 + distance);
    }
    public List<String> splitSentence(String Sentence){
        String regex = "[:!._,'@? -─－\\(\\)\\$「」：、]";
        List<String> sentenceTokens = new ArrayList<>();
        StringTokenizer str = new StringTokenizer(Sentence,regex);
        while(str.hasMoreElements()) {
            sentenceTokens.add(str.nextToken());
        }
        return sentenceTokens;
    }
    public double getCosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }



}
