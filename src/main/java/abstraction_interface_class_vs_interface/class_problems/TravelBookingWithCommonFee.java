import java.util.Locale;
import java.util.Scanner;

public class TravelBookingWithCommonFee {
    private abstract static class Booking {
        private static final double BOOKING_FEE = 50;
        final double distanceKm;
        Booking(double distanceKm) { this.distanceKm = distanceKm; }
        abstract double fare();
        final double total() { return fare() + BOOKING_FEE; }
    }
    private static final class Bus extends Booking {
        Bus(double distance) { super(distance); }
        double fare() { return distanceKm * 2; }
    }
    private static final class Train extends Booking {
        Train(double distance) { super(distance); }
        double fare() { return distanceKm * 1.5; }
    }
    private static final class Flight extends Booking {
        Flight(double distance) { super(distance); }
        double fare() { return 2500 + distanceKm * 4; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); String[] modes = new String[n]; Booking[] bookings = new Booking[n];
        for (int i = 0; i < n; i++) {
            String mode = in.next().toUpperCase(Locale.ROOT); double distance = in.nextDouble(); modes[i] = mode;
            switch (mode) {
                case "BUS": bookings[i] = new Bus(distance); break;
                case "TRAIN": bookings[i] = new Train(distance); break;
                case "FLIGHT": bookings[i] = new Flight(distance); break;
                default: throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }
        }
        for (int i = 0; i < n; i++)
            System.out.printf(Locale.US, "%s: %.2f%n", modes[i], bookings[i].total());
    }
}
