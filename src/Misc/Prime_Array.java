package Misc;
import java.util.Scanner;

public class Prime_Array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Reverse the number
        int reversedNumber = reverseNumber(number);

        // Find prime digits in the reversed number and store by name in an array
        String[] primeDigitsArray = findPrimeDigitsByName(reversedNumber);

        // Display the result
        System.out.println("Reversed Number: " + reversedNumber);
        System.out.println("Prime Digits in Reversed Number: ");
        for (String primeDigit : primeDigitsArray) {
            System.out.print(primeDigit + "");
            
        }
    }

    // Function to reverse a number
    private static int reverseNumber(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }

    // Function to find prime digits in a number and store by name in a string array
    private static String[] findPrimeDigitsByName(int num) {
        StringBuilder primeDigits = new StringBuilder();
        while (num != 0) {
            int digit = num % 10;
            if (isPrime(digit)) {
                primeDigits.insert(0, digitToName(digit)); // Insert at the beginning to maintain the order
            }
            num /= 10;
        }
        return primeDigits.toString().split(" ");
    }

    // Function to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to convert a digit to its name
    private static String digitToName(int digit) {
        switch (digit) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }
}