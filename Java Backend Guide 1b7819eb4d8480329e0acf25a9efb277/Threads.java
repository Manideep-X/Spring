import java.util.Scanner;

class firstHalf extends Thread {
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

class secondHalf extends Thread {
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

public class Threads {
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
        
        f.start();
        s.start();
    }
}
