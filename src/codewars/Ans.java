package codewars;

import java.io.*;
import java.util.*;

public class Ans {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        switch (a){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                out.println(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                out.println(30);
                break;
            case 2:
                out.println(28);
                break;
            default:
                out.println("oh my god danila are you crazy");
        }
        out.flush();
    }
}