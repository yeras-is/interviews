package defult;

/* Дана строка переставить в ней слова наоборот. строка в виде массива симовлов
*  Попытайтесь использовать как можно меньше дополнительных переменных */

/*Given String as a char array , swap words  in back words. Try to use less extra variables.*/


public class ReverseWordsInString {
  public static void main(String[] args) {
    char[] qwe = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
    StringBuilder asd= new StringBuilder();
    for(int i = (String.valueOf(qwe)).split(" ").length-1; i>=0; i--){
      asd.append((String.valueOf(qwe)).split(" ")[i]).append(" ");
    }
    System.out.println(asd);
  }
}
