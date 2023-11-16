//1013(금) -> H2O CyclicBarrier
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main24 {
    Semaphore s1 = new Semaphore(1); //O
    Semaphore s2 = new Semaphore(1); //H

    CyclicBarrier barrier = new CyclicBarrier(3);  //count가 3이되면 종료되도록

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //수소 방출 2
        try {
            barrier.await();

            s2.acquire(); //H소모, 안되면 기다린다.
            releaseHydrogen.run();
            s2.release();
            
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // 산소 방출 1
        try {
            barrier.await();

            s1.acquire(); //H소모
            releaseOxygen.run();
            s2.release();

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } 
    }
}