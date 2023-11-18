//1017(화) -> Blocking Queue
import java.util.LinkedList;
import java.util.Queue;

public class Main26 {
    private Queue<Integer> queue ; //First in First Out (FIFO) 선입선출
    private int capacity;

    public Main26(int capacity) {
        // TODO 1.생성자는 capacity 값으로 queue를 초기화 합니다.
        // queue는 LinkedList를 사용합니다.
        this.capacity = capacity;
        queue = new LinkedList<>();

        if(capacity == 0){
            throw new IllegalArgumentException();
        }
        
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        // TODO 2.queue에 element를 추가합니다.
        // queue가 가득차면 enqueue 메서드를 호출하는 Thread는 queue가 가득 차지 않을 때까지 대기 합니다.
       
        while (queue.size() > capacity) {
            wait();
        }

        queue.add(element);
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        // TODO 3.queue에서 뒤쪽에(가장 먼저 들어온) 있는 요소들을 반환하고 제거 합니다.
        while(queue.isEmpty()){
            wait();
        }
        notifyAll();

        return queue.poll(); //사용할 수 있을 때까지 대기하면서 헤드를 검색하고 제거
    }

    public int size() {
        // TODO 4.현재 queue의 size를 반환합니다.
        return queue.size();
    }
}

