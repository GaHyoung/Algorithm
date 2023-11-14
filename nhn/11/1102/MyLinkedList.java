import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<E> implements ILinkedList<E>, MyList<E>, Iterable<E> {
    // head node
    private Node<E> head;
    // tail node
    private Node<E> tail;
    // linkedlist size
    private int size = 0;

    // 계속 자료 삽입 가능. 항상 true?
    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public void addFirst(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }

        Node<E> node = new Node<>(e);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }

        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    // Node는 E타입이 아니라 E타입을 담고있는 클래스.
    // 따라서 E타입을 반환하려면 Node안에 있는 데이터를 반환해주어야 한다.
    @Override
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E node = head.getData();
        head = head.getNext();

        size--;
        return node;
    }

    @Override
    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        E node = tail.getData();
        tail = tail.getPrev();

        size--;
        return node;
    }

    @Override
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    @Override
    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.getData();
    }

    @Override
    public boolean remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> searchNode = head;
        int tempIndex = 0;
        while (tempIndex != index) {
            searchNode = searchNode.getNext();
            tempIndex++;
        }

        if (searchNode == head) {
            removeFirst();
        } else if (searchNode == tail) {
            removeLast();
        } else {
            searchNode.getPrev().setNext(searchNode.getNext());
            searchNode.getNext().setPrev(searchNode.getPrev());
            size--;
        }
        return true;
    }

    @Override
    public boolean remove(E e) {

        Node<E> searchNode = head;
        while (searchNode != null) {
            if (Objects.equals(searchNode.getData(), e)) {
                if (searchNode == head) {
                    removeFirst();
                } else if (searchNode == tail) {
                    removeLast();
                } else {
                    searchNode.getPrev().setNext(searchNode.getNext());
                    searchNode.getNext().setPrev(searchNode.getPrev());
                    size--;
                }
                return true;
            }
            searchNode = searchNode.getNext();
        }
        return false;

    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getData();

    }

    @Override
    public E set(int index, E element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        node.setData(element);
        return node.getData();
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> searchNode = head;
        while (searchNode != null) {
            if (Objects.equals(searchNode.getData(), o)) {
                return true;
            }
            searchNode = searchNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;
            }
        };
    }

}
