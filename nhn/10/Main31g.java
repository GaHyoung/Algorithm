//1024(화) -> general -> ArrayList로 Stack 구현
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main31g<E> implements IStack<E> , Iterable<E> {
    ArrayList<E> list;
    int capacity;

  public Main31g(int capacity){
    this.capacity = capacity;
    if(capacity <= 0){
        throw new IllegalArgumentException();
    }

    list = new ArrayList<>();
  }

@Override
public Iterator<E> iterator() {
    
    if(!list.iterator().hasNext()){
        throw new NoSuchElementException();
    }

    return list.iterator();
}

@Override
public void push(E item) {
    list.add(item);

}

@Override
public E pop() {
    if(list.isEmpty()){
        throw new EmptyStackException();
    }
    return list.remove(0);
}

@Override
public E peek() {
    if(list.isEmpty()){
        throw new EmptyStackException();
    }
    return list.get(0);
}

@Override
public int search(Object o) {
    if(list.isEmpty()){
        throw new EmptyStackException();
    }

    for(int i = 0; i < list.size(); i++){
        if(list.get(i).equals(o)){
            return i;
        }
    }
    return -1;
    
}

@Override
public boolean empty() {
    if(list.isEmpty()){
        return true;
    }
    return false;
}


    public static void main(String[] args) {
        Main31g<String> stack = new Main31g<>(5);

        // 요소(push) 추가
        stack.push("nhnacademy");
        stack.push("hello");
        stack.push("hi");

        // 스택 순회 및 출력
        System.out.print("Stack elements: ");
        for (String item : stack) {
            System.out.print(item + ", ");
        }

        // 요소(pop) 제거
        String poppedItem = stack.pop();
        System.out.println("Pop: " + poppedItem);

        // 최상단 요소 조회
        String topItem = stack.peek();
        System.out.println("Top: " + topItem);

        // 요소 검색
        int index = stack.search("hello");
        if (index != -1) {
            System.out.println("search index: " + index);
        } else {
            System.out.println("해당 값이 없습니다.");
        }

        // 스택이 비어 있는지 확인
        boolean isEmpty = stack.empty();
        System.out.println("stack empty " + isEmpty);
    }
}
