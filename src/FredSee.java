import java.util.concurrent.Semaphore;

public class FredSee extends Thread{
  private Person fred;
  private Person wilma;
  private Semaphore fredSem;
  private Semaphore wilmaSem;

  static int counter;

  FredSee(Person fred, Person wilma, Semaphore fredSem, Semaphore wilmaSem) {
    this.fred = fred;
    this.wilma = wilma;
    this.fredSem = fredSem;
    this.wilmaSem = wilmaSem;
    counter = 0;
  }

  public void run() {
    try {
      while (counter < 10) {

        fredSem.acquire();

        FredSee.counter++;
        System.out.println("Counter: " + counter);

        while (wilma.height > 1) {
          fred.height += fred.pushStrength;
          wilma.height -= fred.pushStrength;

          System.out.println("Fred height: " + fred.height + ", Wilma height: " + wilma.height);

          sleep(1000);
        }

        wilmaSem.release();

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
