package defult;
//main sort algorithms and O notation
//основные алгоритмы сортировки и сложность выполнения

import java.util.Arrays;

public class Sort {
  private static int[] bubbleSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          //use this swap only to int {
          a[j] = a[j] + a[j + 1];
          a[j + 1] = a[j] - a[j + 1];
          a[j] = a[j] - a[j + 1];
          //}
          /*main swap
           * int temp = a[i];
           * a[i]=a[j];
           * a[j]=temp
           * */
        }
      }
    }
    return a;
  }


  private static int[] insertionSort(int[] a) {
    int in;
    for (int out = 0; out < a.length - 1; out++) {
      int temp = a[out];
      in = out;
      while (in>0 && a[in-1]>temp){
        a[in]=a[in-1];
        in--;
      }
      a[in]=temp;
    }
    return a;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 6, 4, 7, 9, 1, 0, 12, 64, 22, 12, 1};
    System.out.println("Bubble Sort: "+Arrays.toString(bubbleSort(a)));
    System.out.println("Insertion Sort: "+Arrays.toString(insertionSort(a)));

  }

}
