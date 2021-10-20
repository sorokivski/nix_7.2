package task1;

public class FiftyThreads extends Thread {
    int id;
    int qNum;

    public FiftyThreads(int id) {
        this.id = id;
        this.qNum = 49 - id;
    }

    public void run() {

        try {
            sleep(qNum * 100);
            System.out.println("Hello from thread " + id);
        } catch (InterruptedException e) {
            System.out.println("some error occur");
            throw new RuntimeException(e);
        }
    }
}

