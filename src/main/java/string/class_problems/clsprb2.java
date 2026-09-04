package Session1.class_problem;
 import java.util.Arrays;
import java.util.Scanner;

public class clsprb2 {
   
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();

        char[] reversed = text.toCharArray();

        for (int i = 0; i < reversed.length / 2; i++) {

            char temp = reversed[i];

            reversed[i] = reversed[reversed.length - 1 - i];

            reversed[reversed.length - 1 - i] = temp;
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean array = isPalindromeArrayReversal(text);

        System.out.println("Iterative: "
                + (iterative ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (recursive ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (array ? "Palindrome" : "Not Palindrome"));
    }
}
    

