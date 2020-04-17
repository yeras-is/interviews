package fucking_aues;

import java.util.Arrays;
import java.util.Random;

public class OopLab {

    public static void main(String[] args) {
        System.out.println("yeras-is");
        System.out.println("==================================");
        firstTask();
        System.out.println("==================================");
        secondTask();
        System.out.println("==================================");
    }

    private static void secondTask() {
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

    private static void firstTask() {
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
}
