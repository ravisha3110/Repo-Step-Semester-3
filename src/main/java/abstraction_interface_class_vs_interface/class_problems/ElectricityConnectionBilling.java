import java.util.Locale;
import java.util.Scanner;

public class ElectricityConnectionBilling {
    private abstract static class Connection {
        final double units;
        Connection(double units) { this.units = units; }
        abstract double bill();
    }
    private static final class Home extends Connection {
        Home(double units) { super(units); }
        double bill() { return Math.min(units, 100) * 5 + Math.max(0, units - 100) * 7; }
    }
    private static final class Shop extends Connection {
        Shop(double units) { super(units); }
        double bill() { return units * 8 + 100; }
    }
    private static final class Factory extends Connection {
        Factory(double units) { super(units); }
        double bill() { return Math.max(1000, units * 6); }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); Connection[] connections = new Connection[n]; String[] types = new String[n];
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT); double units = in.nextDouble();
            types[i] = type;
            switch (type) {
                case "HOME": connections[i] = new Home(units); break;
                case "SHOP": connections[i] = new Shop(units); break;
                case "FACTORY": connections[i] = new Factory(units); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = connections[i].bill(); total += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", types[i], bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
