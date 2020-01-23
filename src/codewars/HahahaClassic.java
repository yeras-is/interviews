package codewars;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HahahaClassic {
    public static void main(String[] args) {
       Test2();
    }


    public static void Test3() {
        String patternStr = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}";
        Pattern pattern = Pattern.compile(patternStr);

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter password");
        String input = scanner.next();


        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void Test2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the lowest border >=0");
        int a = scanner.nextInt();
        System.out.println("enter the hiest border >=0");
        int b = scanner.nextInt();
        if ((1<=a && a<=b && b<=Math.pow(10,6))){
            System.out.println(-1);
            return;
        }
        StringBuilder places = new StringBuilder();
        for (int i = a; i <= b; i++) {
            int ant = (int) Math.pow(i, 2);
            if (ant % 100 == i) { //если условие подходит
                places.append(i).append(" ");
            }
        }
        if (places.toString().isEmpty()) {
            System.out.println(-1);
        }
        System.out.println(places.toString());

    }

    public static void Test1() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        switch (Integer.parseInt(string)) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(30);
                break;
            case 2:
                System.out.println(28);
                break;
            default:
                System.out.println("danila");
                break;
        }
    }
}
