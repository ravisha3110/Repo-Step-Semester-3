class classprb2 {
    static class Scorecard {
        private final boolean[] answers;
        private int recorded;
        Scorecard(int questionCount) {
            if (questionCount < 0) throw new IllegalArgumentException("Question count cannot be negative");
            answers = new boolean[questionCount];
        }
        boolean recordAnswer(boolean correct) {
            if (recorded == answers.length) return false;
            answers[recorded++] = correct;
            return true;
        }
        int getScore() {
            int score = 0;
            for (int i = 0; i < recorded; i++) if (answers[i]) score++;
            return score;
        }
    }
    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true); scorecard.recordAnswer(true);
        scorecard.recordAnswer(false); scorecard.recordAnswer(true);
        System.out.println("Score: " + scorecard.getScore());
    }
}
