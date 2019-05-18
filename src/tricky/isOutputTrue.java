package tricky;
//got it from JPoint 2016 Aleksandr Matorin

//which output is true

public class isOutputTrue {
  public static void main(String[] args) {
    String a="hello";
    final String b="hel";
    String c="lo";
    String d="hello";

    System.out.println(a==d);
    System.out.println(a==b+c);
    System.out.println(d==b+"lo");
  }
}

//answers 1 and 3  because compiler put "hello" in runtime and vars with same values takes a link, and 3 sout in runtime be "hello"=="hello"

