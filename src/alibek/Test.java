package alibek;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double A, B, C, D, X1, X2;

        System.out.println("Введите число 1");
        A = scanner.nextDouble();
        System.out.println("Введите число 2");
        B = scanner.nextDouble();
        System.out.println("Введите число 3");
        C = scanner.nextDouble();

        D = Math.pow(B, 2) - 4 * A * C;
        if (D < 0) {
            System.out.println("Дискримминант крайне отрицательный, корней нет");
            return;
        }
        X1 = (-1 * B + D) / (2 * A);
        X2 = (-1 * B - D) / (2 * A);
        if (X1 == X2) {
            System.out.println("Единственный корень х=" + X2);
            return;
        }
        System.out.println("Корени х1=" + X1 + " x2=" + X2);
    }
}
