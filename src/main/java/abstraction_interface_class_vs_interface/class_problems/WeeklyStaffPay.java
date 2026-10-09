import java.util.Locale;
import java.util.Scanner;

public class WeeklyStaffPay {
    private abstract static class Staff {
        final String name;
        Staff(String name) { this.name = name; }
        abstract double pay();
    }
    private static final class FullTime extends Staff {
        final double salary;
        FullTime(String name, double salary) { super(name); this.salary = salary; }
        double pay() { return salary; }
    }
    private static final class Hourly extends Staff {
        final double hours, rate;
        Hourly(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        double pay() { return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5; }
    }
    private static final class Intern extends Staff {
        final double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT), name = in.next();
            switch (type) {
                case "FULLTIME": staff[i] = new FullTime(name, in.nextDouble()); break;
                case "HOURLY": staff[i] = new Hourly(name, in.nextDouble(), in.nextDouble()); break;
                case "INTERN": staff[i] = new Intern(name, in.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }
        double total = 0;
        for (Staff person : staff) {
            double pay = person.pay(); total += pay;
            System.out.printf(Locale.US, "%s: %.2f%n", person.name, pay);
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
