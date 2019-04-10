import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        Semaphore fredSem = new Semaphore(1);
        Semaphore wilmaSem = new Semaphore(0);

        Person fred = new Person(1, 1);
        Person wilma = new Person(7, 1.5f);

        FredSee fredSee = new FredSee(fred ,wilma, fredSem, wilmaSem);
        WilmaSaw wilmaSaw = new WilmaSaw(fred, wilma, fredSem, wilmaSem);
        fredSee.start();
        wilmaSaw.start();
    }
}
