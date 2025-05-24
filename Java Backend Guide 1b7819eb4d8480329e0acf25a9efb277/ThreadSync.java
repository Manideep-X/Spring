import java.util.*;

class SharedCounter {
    int count;
    public int getCount() {
        return count;
    }
    public synchronized void increases() {
        count++;
    }
}

public class ThreadSync {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of times to increase the counter (2x)So x: ");
        int n = sc.nextInt();
        sc.close();

        SharedCounter co = new SharedCounter();

        Runnable r1 = () -> {
            for (int i = 0; i < n; i++)
                co.increases();
        };
        Runnable r2 = () -> {
            for (int i = 0; i < n; i++)
                co.increases();
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(co.getCount());
    }
}
