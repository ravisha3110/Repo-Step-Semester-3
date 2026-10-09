import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {
    private abstract static class Cab {
        private static final double MINIMUM_FARE = 100;
        abstract double ratePerKm();
        boolean hasNightService() { return false; }
        final double fare(double km, boolean night) {
            double base = Math.max(MINIMUM_FARE, km * ratePerKm());
            return night ? base * 1.20 : base;
        }
    }
    private interface NightService { }
    private static final class Mini extends Cab { double ratePerKm() { return 10; } }
    private static final class Sedan extends Cab implements NightService {
        double ratePerKm() { return 14; }
        boolean hasNightService() { return true; }
    }
    private static final class SUV extends Cab implements NightService {
        double ratePerKm() { return 18; }
        boolean hasNightService() { return true; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            double km = in.nextDouble(); boolean night = in.next().equalsIgnoreCase("NIGHT");
            Cab cab;
            switch (type) {
                case "MINI": cab = new Mini(); break;
                case "SEDAN": cab = new Sedan(); break;
                case "SUV": cab = new SUV(); break;
                default: throw new IllegalArgumentException("Unknown cab type: " + type);
            }
            if (night && !cab.hasNightService()) {
                System.out.printf("%s: night service not available%n", type);
            } else {
                double fare = cab.fare(km, night); total += fare;
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
