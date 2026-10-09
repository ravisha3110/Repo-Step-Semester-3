import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {
    private abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;
        abstract double seatPrice();
        final double amount(int count) { return count * (seatPrice() + CONVENIENCE_FEE); }
    }
    private static final class Regular extends Ticket { double seatPrice() { return 150; } }
    private static final class Premium extends Ticket { double seatPrice() { return 250; } }
    private static final class Recliner extends Ticket { double seatPrice() { return 400; } }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = in.next().toUpperCase(Locale.ROOT); int count = in.nextInt();
            Ticket ticket;
            switch (seat) {
                case "REGULAR": ticket = new Regular(); break;
                case "PREMIUM": ticket = new Premium(); break;
                case "RECLINER": ticket = new Recliner(); break;
                default: throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
            double amount = ticket.amount(count); total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", seat, amount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
