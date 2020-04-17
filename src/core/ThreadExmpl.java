package core;

public class ThreadExmpl {
  public static void main(String[] args) throws InterruptedException {
    ThreadAB A = new ThreadAB(" A  .", 100);
    Thread threadA = new Thread(A);
    threadA.start();

    ThreadAB B = new ThreadAB(" .  B", 99);
    Thread threadB = new Thread(B);
    threadB.start();

    threadA.join();
    threadB.join();

    System.out.println("-------");
    ThreadAB threadC = new ThreadAB(" C", 99);
    threadC.run();
    System.out.println("=======");


    for (int i = 0; i < 10; i++) {
      Thread.sleep(260);
      System.out.println(" C");
    }

  }

}
