import java.util.concurrent.Semaphore;

public class WilmaSaw extends Thread {
  private Semaphore fredSem;
  private Semaphore wilmaSem;
  private Person fred;
  private Person wilma;

  WilmaSaw(Person fred, Person wilma, Semaphore fredSem, Semaphore wilmaSem) {
    this.fred = fred;
    this.wilma = wilma;
    this.fredSem = fredSem;
    this.wilmaSem = wilmaSem;
  }

  public void run() {
    try {
      while (FredSee.counter < 10) {

        wilmaSem.acquire();

        while (fred.height > 1) {
          fred.height -= wilma.pushStrength;
          wilma.height += wilma.pushStrength;

          System.out.println("Fred height: " + fred.height + ", Wilma height: " + wilma.height);

          sleep(1000);
        }

        fredSem.release();

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
