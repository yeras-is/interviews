package core;

public class ThreadAB implements Runnable {
  private String msg;
  private long timeToSleep;

  public ThreadAB(String msg, long timeToSleep) {
    this.msg = msg;
    this.timeToSleep = timeToSleep;
  }

  @Override
  public void run() {

    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(timeToSleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(msg);
    }

  }
}
