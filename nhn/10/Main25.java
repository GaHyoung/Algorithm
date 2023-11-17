//1016(월) -> Thread 식물 광합성하기. 이산화탄소 생성
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main25 {

    int num = 0;
    CyclicBarrier cyclicBarrier;
    private final int count; 

    public Main25(int count) { //광합성 횟수
        this.count = count;
        this.cyclicBarrier = new CyclicBarrier(3);
    }
    public int getCount() {
        return count;
    }

    //OCO, OOC , O2개 C1개
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        //산소 방출
        for(int i = 0; i < count; i++){
            System.out.println("O");
            releaseOxygen.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void carbon(Runnable releaseCarbon) throws InterruptedException {
        
        //탄소 방출
        for(int i = 0; i < count; i++){
            System.out.println("C");
            releaseCarbon.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume(Runnable plantRoom) throws InterruptedException {

        //이산화탄소 소모
        for (int i = 0; i < count; i++) {
            plantRoom.run();
        }
    }
}

