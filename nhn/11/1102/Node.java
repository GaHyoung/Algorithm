public class Node<E> {
    // Data
    private E data;
    // prev node;
    private Node prev;
    // next node
    private Node next;

    public Node(E e) {
        this.data = e;
    }

    public E getData() {
        return data;
    }
    public Node<E> getPrev() {
        return prev;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setData(E data) {
        this.data = data;
    }
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){ 
            if(this.data == ((Node)obj).data){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
}
