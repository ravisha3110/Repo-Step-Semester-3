class classprb4 {
    static class Locker {
        private final int lockerNumber;
        private String combination;

        Locker(int lockerNumber, String combination) {
            if (combination == null) throw new IllegalArgumentException("Combination cannot be null");
            this.lockerNumber = lockerNumber;
            this.combination = combination;
        }

        boolean changeCode(String currentCode, String newCode) {
            if (!combination.equals(currentCode) || newCode == null) return false;
            combination = newCode;
            return true;
        }

        int getLockerNumber() { return lockerNumber; }
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        System.out.println("Correct code accepted: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong code accepted: " + locker.changeCode("0000", "9999"));
    }
}
