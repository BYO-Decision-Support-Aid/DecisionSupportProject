public class AlternativeEvaluator {
    public String getOptimalAlternative(String[] alternatives, double[][] values) {
        int numAlternatives = alternatives.length;
        int numCriteria = values[0].length;
        int[] scores = new int[numAlternatives];

        // Compare each alternative against every other alternative for each criterion
        for (int i = 0; i < numAlternatives; i++) {
            for (int j = 0; j < numAlternatives; j++) {
                if (i != j) {
                    for (int k = 0; k < numCriteria; k++) {
                        if (values[i][k] > values[j][k]) {
                            scores[i]++;
                        } else if (values[i][k] < values[j][k]) {
                            scores[j]++;
                        }
                    }
                }
            }
        }

        // Find the alternative with the highest score
        int maxScore = Integer.MIN_VALUE;
        int optimalIndex = -1;
        for (int i = 0; i < numAlternatives; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                optimalIndex = i;
            }
        }

        return alternatives[optimalIndex];
    }
}
