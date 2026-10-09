class classprb1 {
    static class PiggyBank {
        private double savings;
        private final int bankNumber;

        PiggyBank(int bankNumber) {
            this.bankNumber = bankNumber;
        }

        void deposit(double amount) {
            if (amount > 0) savings += amount;
        }

        boolean withdraw(double amount) {
            if (amount <= 0 || amount > savings) return false;
            savings -= amount;
            return true;
        }

        double getSavings() { return savings; }
        int getBankNumber() { return bankNumber; }
    }

    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank(101);
        bank.deposit(100);
        bank.withdraw(30);
        bank.withdraw(500);
        System.out.println("Bank " + bank.getBankNumber() + " savings: " + bank.getSavings());
    }
}
