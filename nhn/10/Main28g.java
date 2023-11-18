//1019(목) -> general -> 배열을 이용한 Stack 구현
import java.util.Iterator;

public class Main28g<E> implements Iterable {
    private int top;
    private final int[] arr;

    private final int capacity;

    public Main28g(int capacity) {
        
        if(capacity < 0){
            throw new IllegalArgumentException();
        }
        top = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int data) {
        // TODO 1.stack에 data를 넣습니다.
        // 스택의 맨 위로 쌓는다.

        if(top > capacity){
            throw new IllegalArgumentException();
        }
        arr[++top] = data;
    }

    public int pop() {
        // TODO 2.데이터를 반환하고 반환된 데이터는 stack에서 제거됩니다.
        
        if(top < -1){
            throw new IllegalArgumentException();
        }
        int popValue = arr[top--];

        return popValue;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() { //다음값이 있는지 확인
                //top은 스택의 길이
                if(top > -1){
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() { //다음값
                int next = 0;
                if(hasNext()){
                    next = arr[top--];
                }
                return next;

            }
        };
    }
}