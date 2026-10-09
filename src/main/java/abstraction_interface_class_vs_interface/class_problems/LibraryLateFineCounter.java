import java.util.Locale;
import java.util.Scanner;

public class LibraryLateFineCounter {
    private abstract static class LibraryItem {
        final String title;
        final int daysLate;
        LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        abstract double fine();
    }
    private static final class Book extends LibraryItem {
        Book(String title, int days) { super(title, days); }
        double fine() { return 2.0 * daysLate; }
    }
    private static final class DVD extends LibraryItem {
        DVD(String title, int days) { super(title, days); }
        double fine() { return Math.min(5.0 * daysLate, 50.0); }
    }
    private static final class Magazine extends LibraryItem {
        Magazine(String title, int days) { super(title, days); }
        double fine() { return daysLate; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); LibraryItem[] items = new LibraryItem[n];
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT), title = in.next(); int days = in.nextInt();
            switch (type) {
                case "BOOK": items[i] = new Book(title, days); break;
                case "DVD": items[i] = new DVD(title, days); break;
                case "MAGAZINE": items[i] = new Magazine(title, days); break;
                default: throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine(); total += fine;
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
