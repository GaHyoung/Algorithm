//1006(금) -> Thread 순서대로 출력
public class Main21 {
    int count = 0;

    //메서드별 job은 다른객체이므로 job에 notifyAll,wait걸면 안되고 Job클래스 자체에 걸어야함
    public synchronized void firstJob(Runnable job) throws InterruptedException {
        while(count<3){
            if(count==0){
                job.run();
                count++;
                notifyAll();
                break;
            }
            wait();            
        }
    }
    
    public synchronized void secondJob(Runnable job) throws InterruptedException{
        while(count<3){
            if(count==1){
                job.run();
                count++;
                notifyAll();
                break;
            }
            wait();
        }
    }

    public synchronized void thirdJob(Runnable job) throws InterruptedException{
        while(count<3){
            if(count==2){
                job.run();
                count++;
                notifyAll();
                break;
            }
            wait();
        }
    }


    public static void main(String[] args) {
        Main21 job = new Main21();

        Thread thread1 = new Thread(() -> {
            try {
                job.firstJob(() -> System.out.println("Thread 1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                job.secondJob(() -> System.out.println("Thread 2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                job.thirdJob(() -> System.out.println("Thread 3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
