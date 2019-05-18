package codewars;

import java.util.Scanner;
//дано слово нужно проверить является ли слово изограммой(нет одинаковых букв)
//given word check is there a same letters

public class isIsogram {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String string = scanner.next();
    boolean isIsogram = (string.length() == string.toLowerCase().chars().distinct().count());
    System.out.println(isIsogram);
  }
}
