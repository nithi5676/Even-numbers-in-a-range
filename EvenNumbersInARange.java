package evenNumbersInRange;

import java.util.Scanner;

public class EvenNumbersInARange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        System.out.println("Enter array elemnets ");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter the number of queries");
        int queries = scanner.nextInt();
        int b[][] = new int[queries][2];
        for (int j = 0; j < queries; j++) {
            for (int k = 0; k < 2; k++) {
                b[j][k] = scanner.nextInt();
            }
        }
        scanner.close();
        EvenNumbersInARange evenNumbersInARange = new EvenNumbersInARange();
        evenNumbersInARange.evenSum(array, b, size, queries);

    }

    public void evenSum(int array[], int b[][], int size, int queries) {
        int p[] = new int[size];
        int result[] = new int[size];
        p[0] = array[0] % 2 == 0 ? 1 : 0;
        for (int i = 1; i < size; i++) {
            p[i] = p[i - 1] + (array[i] % 2 == 0 ? 1 : 0);
        }
        int i1 = 0;
        while (queries > 0) {
            int l = b[i1][0];
            int r = b[i1][1];
            if (l == 0) {
                result[i1] = p[r];
            } else {
                result[i1] = p[r] - p[l - 1];
            }
            System.out.println(result[i1]);
            i1++;
            queries--;
        }

    }
}
