import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private abstract static class Appliance {
        private static final double RATE_PER_KWH = 8;
        final double hours;
        Appliance(double hours) { this.hours = hours; }
        abstract double powerWatts();
        boolean supportsSaver() { return false; }
        final double units(boolean saver) {
            double value = powerWatts() * hours / 1000;
            return saver ? value * 0.75 : value;
        }
        final double cost(boolean saver) { return units(saver) * RATE_PER_KWH; }
    }
    private interface SaverMode { }
    private static final class Fridge extends Appliance { Fridge(double h) { super(h); } double powerWatts() { return 150; } }
    private static final class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double h) { super(h); } double powerWatts() { return 1500; }
        boolean supportsSaver() { return true; }
    }
    private static final class Television extends Appliance { Television(double h) { super(h); } double powerWatts() { return 100; } }
    private static final class Washer extends Appliance implements SaverMode {
        Washer(double h) { super(h); } double powerWatts() { return 500; }
        boolean supportsSaver() { return true; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT); double hours = in.nextDouble();
            boolean saver = in.hasNext("SAVER"); if (saver) in.next();
            Appliance appliance;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AirConditioner(hours); break;
                case "TV": appliance = new Television(hours); break;
                case "WASHER": appliance = new Washer(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + type);
            }
            if (saver && !appliance.supportsSaver()) {
                System.out.printf("%s: saver mode not supported%n", type);
            } else {
                double units = appliance.units(saver), cost = appliance.cost(saver);
                totalCost += cost;
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            }
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
