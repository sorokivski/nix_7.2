package task1;

import java.util.Scanner;
import java.util.Stack;

public class Task1Controller {

    public void runTask1v1() {
        for (int i = 0; i < 50; i++)
            new FiftyThreads(i).start();

    }

    public void runTask1v2() {
        Stack<Thread> threads = new Stack<>();
        for (int i = 0; i < 50; i++) {

            Thread thread = new Thread();
            thread.start();
            threads.push(thread);

        }
        while (threads.size() != 0) {
            try {
                System.out.println("Hello from " + threads.peek().getName());
                threads.peek().sleep(100);
                threads.pop().join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void runTask1() {
        System.out.println("Enter version to proceed task 1 (1 or 2): ");
        Scanner in = new Scanner(System.in);
        if ("1".equals(in.nextLine())) {
            runTask1v1();
        } else {
            runTask1v2();
        }

    }
}
