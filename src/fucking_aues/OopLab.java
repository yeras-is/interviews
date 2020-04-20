package fucking_aues;

import java.util.Arrays;
import java.util.Random;

public class OopLab {

    public static void main(String[] args) {
        System.out.println("yeras-is");
        count_is_positive_changed_times();
        hz_not_remember();
        sort_matrix_main_diagonal_asc();
        transform_matfix_by_clock_moving();
    }

    static void count_is_positive_changed_times() {
        System.out.println("\n count_is_positive_changed_times");
        int[] answers = new Random().ints(15, -100, 100).toArray();
        int count = 0;
        boolean isPos = answers[0] >= 0;
        System.out.println("Array:" + Arrays.toString(answers));
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] >= 0 && !isPos) {
                count++;
                isPos = true;
            }
            if (answers[i] < 0 && isPos) {
                count++;
                isPos = false;
            }
        }

        System.out.println("Changed " + count + " times");
    }

    static void hz_not_remember() {
        System.out.println("\n hz_not_remember");
        double x = 1;
        double step = 0.01;
        int counter = 0;
        int size = (int) ((int) (5 - x) / step) + 10;

        double[] answers = new double[size];

        double e = 2.71828182846;

        while (x < 5) {
            answers[counter++] = Math.pow(e, 2 / x) - Math.cos(2 * x) + 1;
            x += step;
        }

        counter = 0;
        for (double q : answers) {
            if (q == 0.0)
                return;
            System.out.println("Num:" + counter++ + " = " + q);
        }
    }

    static void sort_matrix_main_diagonal_asc() {
        System.out.println("\n sort_matrix_main_diagonal_asc");
        int n = 5;
        System.out.println("До сортировки");

        int[][] mas = new int[n][n];

        StringBuilder before = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = new Random().nextInt(10);
                before.append("[").append(mas[i][j]).append("]");
            }
            before.append("\n");
        }
        System.out.println(before.toString());
        System.out.println("После сортировки");


        for (int i = 0; i < 5; ++i)
            insertion_sort(mas[i]);


        StringBuilder after = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                after.append("[").append(mas[i][j]).append("]");
            }
            after.append("\n");
        }

        System.out.println(after);
    }

    static void insertion_sort(int arr[]) {
        for (int i = 1; i < 5; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = swap;
                }
            }
        }
    }

    static void transform_matfix_by_clock_moving() {
        System.out.println("\n transform_matfix_by_clock_moving");
        int N = 5;

        int[][] A = new int[N * 2][N * 2];
        int[][] B1 = new int[N * 2][N * 2];
        int[][] B2 = new int[N * 2][N * 2];
        int[][] B3 = new int[N * 2][N * 2];
        int[][] B4 = new int[N * 2][N * 2];
        int i;
        int j;
        int k;
        int m;

        System.out.println("before");
        StringBuilder before = new StringBuilder();
        for (int q = 0; q < N * 2; q++) {
            for (int w = 0; w < N * 2; w++) {
                if (w == 5)
                    before.append(" ");
                A[q][w] = new Random().nextInt(9);
                before.append("[").append(A[q][w]).append("]");
            }
            if (q == 4)
                before.append("\n");
            before.append("\n");
        }
        System.out.println(before.toString());

//создаем блоки В1..В4
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                B1[i][j] = A[i][j];

        for (i = 0; i < N; i++)
            for (j = N, m = 0; j < 2 * N; j++, m++)
                B2[i][m] = A[i][j];

        for (i = N, k = 0; i < 2 * N; i++, k++)
            for (j = N, m = 0; j < 2 * N; j++, m++)
                B3[k][m] = A[i][j];

        for (i = N, k = 0; i < 2 * N; i++, k++)
            for (j = 0; j < N; j++)
                B4[k][j] = A[i][j];

//собираем блоки в А
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                A[i][j] = B4[i][j];

        for (i = 0; i < N; i++)
            for (j = N, k = 0; j < 2 * N; j++, k++)
                A[i][j] = B1[i][k];

        for (i = N, k = 0; i < 2 * N; i++, k++)
            for (j = N, m = 0; j < 2 * N; j++, m++)
                A[i][j] = B2[k][m];

        for (i = N, k = 0; i < 2 * N; i++, k++)
            for (j = 0; j < N; j++)
                A[i][j] = B3[k][j];


        System.out.println("after");
        before = new StringBuilder();
        for (int q = 0; q < N * 2; q++) {
            for (int w = 0; w < N * 2; w++) {
                if (w == 5)
                    before.append(" ");
                before.append("[").append(A[q][w]).append("]");
            }
            if (q == 4)
                before.append("\n");

            before.append("\n");
        }
        System.out.println(before.toString());

    }
}
