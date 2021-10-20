import task1.FiftyThreads;

public class MainUnit14 {

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++)
            new FiftyThreads(i).start();
    }

}