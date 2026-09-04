package Session4.class_problem;

import java.util.Scanner;

class classprb2 {
    static int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int bestProfit = 0;
        for (int price : prices) {
            if (price < lowestPrice) lowestPrice = price;
            else if (price - lowestPrice > bestProfit) bestProfit = price - lowestPrice;
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = scanner.nextInt();
        System.out.println(maxProfit(prices));
    }
}
