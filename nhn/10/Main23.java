//1012(목) -> Zero Even Odd
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Main23 {
    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore z1 = new Semaphore(1);

    private int n;
    int count = 1;

    public Main23(int n) {
        this.n = n;

        if(n<1 || n >100){
            throw new IllegalArgumentException();
        }
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 0; i < n ; i++){
            while(z1.availablePermits() == 0){
                wait();
            }
            z1.acquire();
            printNumber.accept(0);
            s1.release();
            notifyAll();
        }
    }

    //짝수
    public synchronized void even(IntConsumer printNumber) throws InterruptedException {

        for(int i = 2; i <= n; i+=2){
            while(count % 2 != 0){ //짝수가 아니면 대기
                wait();
            }
            s1.acquire();
            printNumber.accept(count);
            count++;
            z1.release();
            notifyAll();
        }
    }

    //홀수
    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1; i <= n; i+=2){
            while(count % 2 != 1){ //홀수가 아니면 대기
                wait();
            }
            s1.acquire();
            printNumber.accept(count);
            count++;
            z1.release();
            notifyAll();
        }
    }


    public static void main(String[] args) {
        int n = 5;

        Main23 zeroEvenOdd = new Main23(n);
        StringBuilder result = new StringBuilder();
        IntConsumer consumer = result::append;

        Runnable zeroTask = () -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable evenTask = () -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable oddTask = () -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 각각의 작업을 수행할 스레드 생성
        Thread threadA = new Thread(zeroTask);
        Thread threadB = new Thread(evenTask);
        Thread threadC = new Thread(oddTask);

        // 스레드 시작
        threadA.start();
        threadB.start();
        threadC.start();

        try {
            // 각각의 스레드가 종료될 때까지 대기
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 결과 출력
        System.out.println(result.toString());
    }


    
}
