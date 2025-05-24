import java.util.Scanner;

class firstHalf implements Runnable {
    private int n;
    void setN(int n) {
        this.n = n;
    }
    public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println("1st Half: " + (i+1));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}

class secondHalf implements Runnable {
    private int n;
    void setN(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("2nd Half: " + (i+1));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadsRunnable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of 1st/2nd half: ");
        int n = sc.nextInt();
        sc.close();

        firstHalf f = new firstHalf();
        secondHalf s = new secondHalf();

        f.setN(n);
        s.setN(n);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();

        // f.start();
        // s.start();
    }
}
