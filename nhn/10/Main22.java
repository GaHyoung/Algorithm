//1010(화) -> Thread 동시성 제어, 1과 2의 반복
import java.util.concurrent.Semaphore;

public class Main22 {
    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(1);
    private final int count;

    public Main22(int count) {
        this.count = count;
    }
    
    public void printOne(Runnable runnable) throws InterruptedException {
        int i = 0;
        while(i < count){
            s2.acquire();
            runnable.run();
            s1.release();
            i++;
        }
    }

    public void printTwo(Runnable runnable) throws InterruptedException {
        int i = 0;
        while (i < count) {
            s1.acquire();
            runnable.run();
            s2.release();
            i++;
        }
    }

    public static void main(String[] args) {
        Main22 oneTwo = new Main22(3); // You can adjust the count as needed

        Thread thread1 = new Thread(() -> {
            try {
                oneTwo.printOne(() -> System.out.print("Thread 1 "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                oneTwo.printTwo(() -> System.out.println("Thread 2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
