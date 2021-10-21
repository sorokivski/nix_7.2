package task2;

import java.util.concurrent.Semaphore;

public class TwoThreads implements Runnable {

    public volatile int num = 0;
    Semaphore sem;
    private final int id;

    public TwoThreads(Semaphore s, int id) {

        sem = s;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            while (Task2Controller.CommonResource.pos < Task2Controller.CommonResource.listOfNumbers.size() - 1) {

                sem.acquire();

                if (Task2Controller.CommonResource.isSimple()) {
                    Task2Controller.CommonResource.increaseNumOf();
                    System.out.println("\ncurrent number of simple numbers in array: " + Task2Controller.CommonResource.numOf);
                }
                Thread.currentThread().sleep(200);
                Task2Controller.CommonResource.pos++;
                sem.release();
            }
        } catch (InterruptedException e) {
            System.out.println("some error occur");
            throw new RuntimeException(e);
        }
    }


}
