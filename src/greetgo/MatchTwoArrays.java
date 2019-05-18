package greetgo;

/*
 * дано 2 примитивных массива и надо сравнить и найти элементы 1 массива
 * которых нет во 2 массиве. нельзя создавать дополнительные массивы
 * и пользоватся готовыми функциями .consist()
 * */

/* given 2 primitive array and it is necessary to compare and find the elements of 1 array
 * which are not in 2 array. you cannot create additional arrays and using ready-made functions
 */


public class MatchTwoArrays {
  public static void main(String[] args) {
    int a[] = {1, 2, 3, 43, 2, 23, 4, 4, 25, 3, 534, 534, 534, 3, 4, 7, 4, 5};
    int b[] = {1, 2, 3, 88, 4, 4, 3, 45};

    for (int i : a) {
      boolean consist = false;
      for (int j : b) {
        if (i == j) {
          consist = true;
        }
      }
      if (!consist) {
        System.out.println(i);
      }
    }

  }
}
