class assiprb3 {
    static class PasswordStrengthChecker {
        private final int strength;

        PasswordStrengthChecker(String password) {
            if (password == null) throw new IllegalArgumentException("Password cannot be null");
            strength = calculateStrength(password);
        }

        private int calculateStrength(String password) {
            int score = 0;
            if (password.length() >= 8) score++;
            if (password.matches(".*[A-Z].*")) score++;
            if (password.matches(".*[a-z].*")) score++;
            if (password.matches(".*[0-9].*")) score++;
            if (password.matches(".*[^A-Za-z0-9].*")) score++;
            return score;
        }

        String getStrength() {
            if (strength <= 2) return "Weak";
            if (strength <= 4) return "Moderate";
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordStrengthChecker checker = new PasswordStrengthChecker("StepJava#2026");
        System.out.println("Password strength: " + checker.getStrength());
    }
}
