import task1.Task1Controller;
import task2.Task2Controller;


public class MainUnit14 {

    public static void main(String[] args) {
        System.out.println("_____________________________________________TASK 1____________________________________________");
         new Task1Controller().runTask1();
        try {
            Thread.sleep(5555);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("_____________________________________________TASK 2____________________________________________");
        new Task2Controller().runTask2();
    }
}