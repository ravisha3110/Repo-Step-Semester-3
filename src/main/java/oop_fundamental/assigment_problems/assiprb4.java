class assiprb4 {
    static class TrafficLight {
        private enum Color { RED, GREEN, YELLOW }
        private Color color = Color.RED;
        void next() {
            switch (color) {
                case RED: color = Color.GREEN; break;
                case GREEN: color = Color.YELLOW; break;
                case YELLOW: color = Color.RED; break;
            }
        }
        String getColor() { return color.name(); }
    }
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        System.out.println(light.getColor()); light.next();
        System.out.println(light.getColor()); light.next();
        System.out.println(light.getColor()); light.next();
        System.out.println(light.getColor());
    }
}
