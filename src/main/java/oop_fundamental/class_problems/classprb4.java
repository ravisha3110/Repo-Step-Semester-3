class classprb4 {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int score : row) {
            total += score;
        }
        return (double) total / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ");
            result.append(rowAverage(seatingScores[i]) < threshold ? "Quiet Zone" : "Buzzing Zone");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(seatingScores, 60));
    }
}
