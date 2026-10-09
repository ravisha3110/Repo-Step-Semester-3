import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {
    private abstract static class Student {
        final String name;
        Student(String name) { this.name = name; }
        abstract double tuition();
        boolean usesBus() { return false; }
        final double totalFee() { return tuition() + (usesBus() ? 12000 : 0); }
    }
    private static final class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000; }
        boolean usesBus() { return true; }
    }
    private static final class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 40000 + 60000; }
    }
    private static final class Scholar extends Student {
        Scholar(String name) { super(name); }
        double tuition() { return 20000; }
        boolean usesBus() { return true; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); double collected = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT), name = in.next();
            Student student;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new Scholar(name); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
            double fee = student.totalFee(); collected += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", collected);
    }
}
