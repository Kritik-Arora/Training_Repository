package Misc;
import java.util.Scanner;

public class Twod_Array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];
        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        System.out.print("Enter the target word to search: ");
        String targetWord = scanner.next();

        findOccurrences(matrix, targetWord ,rows ,cols);

        scanner.close();
    }

    public static void findOccurrences(String[][] matrix, String targetWord , int rows , int cols) {
        boolean found = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                if (matrix[i][j].equals(targetWord)) {
                    System.out.println("Word '" + targetWord + "' found at position: (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Word '" + targetWord + "' not found in the matrix.");
        }
    }
}