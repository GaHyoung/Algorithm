//1102(목) -> MyLinkedList을 이용해서 Queue와 Test 구현
public class MyQueue<E> extends MyLinkedList<E> implements IQueue<E> {

    final int MAXSIZE = 10;
    
    @Override
    public boolean add(E e) {
        //데이터 추가 시 큐가 꽉 찼을때 add는 예외를 반환, offer는 false를 반환
        if(size() == MAXSIZE){
            throw new IllegalStateException();
        }
        addLast(e);        
        return true;}

    @Override
    public E element() {
        if(size() == 0){
            throw new IllegalArgumentException();
        }
        return getFirst();
    }

    @Override
    public boolean offer(E e) {
        if(size() == MAXSIZE){
            return false;
        }
        addLast(e);
        return true;
    }

    @Override
    public E poll() {
        //remove() : 큐가 비어 있는 경우 NoSuchElementException 에러 발생. 
        //poll() : 큐가 비어 있을 경우 null 반환
        if(size() == 0){
            return null;
        }
        return removeFirst();
    }

    @Override
    public E peek() {
        //element() : 큐가 비어 있는 경우 NoSuchElementException 에러 발생
        // peek() : 비어있는 경우 null 반환
        if(size() == 0){
            return null;
        }
        return getFirst();
    }
}