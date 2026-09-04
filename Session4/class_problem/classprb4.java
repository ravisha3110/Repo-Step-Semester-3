package Session4.class_problem;

import java.util.Scanner;

class classprb4 {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int index = 0;
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) result[index++] = arr1[first++];
            else result[index++] = arr2[second++];
        }
        while (first < arr1.length) result[index++] = arr1[first++];
        while (second < arr2.length) result[index++] = arr2[second++];
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstLength = scanner.nextInt();
        int[] arr1 = new int[firstLength];
        for (int i = 0; i < firstLength; i++) arr1[i] = scanner.nextInt();
        int secondLength = scanner.nextInt();
        int[] arr2 = new int[secondLength];
        for (int i = 0; i < secondLength; i++) arr2[i] = scanner.nextInt();
        for (int value : mergeSortedArrays(arr1, arr2)) System.out.print(value + " ");
    }
}
