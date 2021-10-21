package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Task2Controller {

    public void runTask2() {

        new CommonResource().fulfillList();
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(new TwoThreads(semaphore, 1));
        Thread t2 = new Thread(new TwoThreads(semaphore, 2));
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total number of simple values:" + CommonResource.numOf);

    }

    static class CommonResource {

        public static volatile int numOf = 0;
        public static volatile int pos = 0;
        static List<Integer> listOfNumbers;
        private final int SIZE_OF_LIST = 20;

        public static void increaseNumOf() {
            numOf++;
        }

        public static boolean isSimple() {

            for (int i = 2; i < listOfNumbers.get(pos); i++) {
                if (listOfNumbers.get(pos) % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public void fulfillList() {
            listOfNumbers = new ArrayList<>(SIZE_OF_LIST);
            for (int i = 0; i < SIZE_OF_LIST; i++) {
                listOfNumbers.add((int) (Math.random() * i));
                System.out.print(listOfNumbers.get(i) + "  ");
            }
        }
    }
}
