import java.util.Locale;
import java.util.Scanner;

/** Garden Plot Area Report: a shared abstraction for plots with different area formulas. */
public class GardenPlotAreaReport {
    private abstract static class Plot {
        private final String owner;
        private final String shape;

        Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        abstract double area();

        String report() {
            return String.format(Locale.US, "%s (%s): %.2f", owner, shape, area());
        }
    }

    private static final class Circle extends Plot {
        private final double radius;
        Circle(String owner, double radius) { super(owner, "CIRCLE"); this.radius = radius; }
        @Override double area() { return Math.PI * radius * radius; }
    }

    private static final class Rectangle extends Plot {
        private final double length, width;
        Rectangle(String owner, double length, double width) {
            super(owner, "RECTANGLE"); this.length = length; this.width = width;
        }
        @Override double area() { return length * width; }
    }

    private static final class Triangle extends Plot {
        private final double base, height;
        Triangle(String owner, double base, double height) {
            super(owner, "TRIANGLE"); this.base = base; this.height = height;
        }
        @Override double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) return;
        int count = input.nextInt();
        Plot[] plots = new Plot[count];
        for (int i = 0; i < count; i++) {
            String shape = input.next().toUpperCase(Locale.ROOT);
            String owner = input.next();
            switch (shape) {
                case "CIRCLE": plots[i] = new Circle(owner, input.nextDouble()); break;
                case "RECTANGLE": plots[i] = new Rectangle(owner, input.nextDouble(), input.nextDouble()); break;
                case "TRIANGLE": plots[i] = new Triangle(owner, input.nextDouble(), input.nextDouble()); break;
                default: throw new IllegalArgumentException("Unsupported plot shape: " + shape);
            }
        }
        double total = 0;
        for (Plot plot : plots) {
            System.out.println(plot.report());
            total += plot.area();
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
