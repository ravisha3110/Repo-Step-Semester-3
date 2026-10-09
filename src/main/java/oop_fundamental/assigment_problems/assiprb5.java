class assiprb5 {
    static class Cart {
        private final double[] prices;
        private int itemCount;
        Cart(int capacity) {
            if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
            prices = new double[capacity];
        }
        boolean addItem(double price) {
            if (price < 0 || itemCount == prices.length) return false;
            prices[itemCount++] = price;
            return true;
        }
        double getTotal() {
            double total = 0;
            for (int i = 0; i < itemCount; i++) total += prices[i];
            return total;
        }
        int getItemCount() { return itemCount; }
    }
    public static void main(String[] args) {
        Cart cart = new Cart(5);
        cart.addItem(12.50); cart.addItem(8.25); cart.addItem(4.00);
        System.out.printf("Items: %d, total: %.2f%n", cart.getItemCount(), cart.getTotal());
    }
}
