package defult;
//переворнуть строчку = укчортс ьтунровереп
//string reverse = esrever gnirts

public class StringReverse {
  public static void main(String[] args) {
    char[] string = "Hello World".toCharArray();
    //same methods but for is better
    /*int i = 0, j = string.length - 1;
    while (i < j) {
      char a = string[i];
      string[i] = string[j];
      string[j] = a;
      i++;
      j--;
    }*/
    for (int q = 0, w = string.length - 1; q < w; q++, w--) {
      char a = string[q];
      string[q] = string[w];
      string[w] = a;
    }
    System.out.println(string);
  }
}
