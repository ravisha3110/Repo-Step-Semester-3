package Session4.class_problem;

import java.util.Scanner;

class classprb5 {
    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;
        k %= nums.length;
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) rotated[(i + k) % nums.length] = nums[i];
        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        int k = scanner.nextInt();
        for (int value : rotateArray(nums, k)) System.out.print(value + " ");
    }
}
