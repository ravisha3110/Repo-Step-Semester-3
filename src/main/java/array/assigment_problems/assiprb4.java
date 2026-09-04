package Session4.assignment_problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class assiprb4 {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        frequencies.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int num : nums) {
            currentSum += num;
            count += frequencies.getOrDefault(currentSum - k, 0);
            frequencies.put(currentSum, frequencies.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(subarraySum(nums, k));
    }
}
