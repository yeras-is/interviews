package tricky;
//got it from JPoint 2016 Aleksandr Matorin


//какой вывод напечатает false?
//which output print false?

public class isEqualsFalse {
  public static void main(String[] args) {
    String string = "hello";
    StringBuilder b1 = new StringBuilder("hello");
    StringBuilder b2 = new StringBuilder("hello");

//    System.out.println(string==b1);
    System.out.println(string.equals(b1));
    System.out.println(b1.equals(b2));
  }
}




/*right answers is 2 and 3
* because 1  String and Builder cannot be equal and there got a compile error
* 2 is false
* 3 because Builder cannot Override methods and equals work with valueOf();
* */
