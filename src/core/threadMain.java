package core;

public class threadMain {
  public static void main(String[] args) throws InterruptedException {
    ThreadAB A = new ThreadAB("A", 50);
    Thread threadA = new Thread(A);
    /*ThreadAB B = new ThreadAB(" B", 25);
    Thread threadB = new Thread(B);
    */
    threadA.start();

    for (int i = 0; i < 10; i++) {
      Thread.sleep(260);
      System.out.println(" C");
    }

    System.out.println("aaaa");
    threadA.join();
    System.out.println("bbbb");



  }
}
