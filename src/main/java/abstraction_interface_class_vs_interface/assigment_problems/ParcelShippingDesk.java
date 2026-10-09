import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {
    private abstract static class Parcel {
        final double weight;
        Parcel(double weight) { this.weight = weight; }
        abstract double shippingCharge();
        double insurance(double declaredValue) { return 0; }
    }
    private interface Insurable { double insurance(double declaredValue); }
    private static final class Standard extends Parcel {
        Standard(double weight) { super(weight); }
        double shippingCharge() { return 40 + 10 * weight; }
    }
    private static final class Express extends Parcel implements Insurable {
        Express(double weight) { super(weight); }
        double shippingCharge() { return 80 + 15 * weight; }
        public double insurance(double value) { return value * 0.02; }
    }
    private static final class Fragile extends Parcel implements Insurable {
        Fragile(double weight) { super(weight); }
        double shippingCharge() { return 40 + 10 * weight + 50; }
        public double insurance(double value) { return value * 0.02; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); in.useLocale(Locale.US);
        if (!in.hasNextInt()) return;
        int n = in.nextInt(); double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            double weight = in.nextDouble(), value = in.nextDouble();
            Parcel parcel;
            switch (type) {
                case "STANDARD": parcel = new Standard(weight); break;
                case "EXPRESS": parcel = new Express(weight); break;
                case "FRAGILE": parcel = new Fragile(weight); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
            double insurance = parcel instanceof Insurable ? ((Insurable) parcel).insurance(value) : 0;
            double charge = parcel.shippingCharge(), total = charge + insurance;
            grandTotal += total;
            System.out.printf(Locale.US, "%s:%nCharge=%.2f%nInsurance=%.2f%nTotal=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
