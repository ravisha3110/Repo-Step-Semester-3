class assiprb1 {
    static class HealthBar {
        private final int maximumHealth;
        private int health;

        HealthBar(int maximumHealth) {
            if (maximumHealth <= 0) throw new IllegalArgumentException("Maximum health must be positive");
            this.maximumHealth = maximumHealth;
            health = maximumHealth;
        }

        void takeDamage(int amount) {
            if (amount > 0) health = Math.max(0, health - amount);
        }

        void heal(int amount) {
            if (amount > 0) health = Math.min(maximumHealth, health + amount);
        }

        int getHealth() { return health; }
    }

    public static void main(String[] args) {
        HealthBar bar = new HealthBar(100);
        bar.takeDamage(35);
        bar.heal(10);
        bar.takeDamage(200);
        System.out.println("Health: " + bar.getHealth());
    }
}
