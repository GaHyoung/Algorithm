//1113(월) -> HashMap, Test 구현
public class MyHashMap<K,V> implements IMap<K,V> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size;
  private Object[] table = new Object[DEFAULT_CAPACITY]; //Object타입에서 HashNode<K, V>로 변환! hashMap 담아두는 용도.

  
  @Override
  public void clear() {
    for(int i = 0; i < size; i++){
        table[i] = null;
    }
    size = 0;
  }


  @Override
  public boolean containsKey(K key) {
    int hash = key.hashCode() % DEFAULT_CAPACITY;
    int index = hash;

    // 현재 인덱스의 첫 번째 노드
    HashNode<K, V> current = (HashNode<K, V>)table[index];

    while (current != null) {
        if (current.getKey().equals(key)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
  }


  @Override
  public boolean containsValue(V value) {
    
    HashNode<K, V> current;
    //해당 테이블로 이동
    for(int i = 0; i < table.length; i++){ 
        //테이블이 null이 아닌 경우 getNext()로 일치하는 값 찾기
        for(current = (HashNode<K, V>) table[i]; current != null; current = current.getNext()){ 
            if(current.getValue() == value && value !=null){
                return true;
            }
        }
    }
    return false;
  }


  @Override
  public V get(K key) {
    int hash = key.hashCode() % DEFAULT_CAPACITY;
    int index = hash;

    HashNode<K, V> current = (HashNode<K, V>) table[index];

    while (current != null) {
        if (current.getKey().equals(key)) {
            return current.getValue();
        }
        current = current.getNext();
    }
    return null;
  }


  @Override
  public boolean isEmpty() {
    return size == 0;
  }


  @Override
  public V put(K key, V value) {
    if(size == DEFAULT_CAPACITY){
        throw new IllegalStateException();
    }
    
    int hash = key.hashCode() % DEFAULT_CAPACITY;
    int index = hash;
    
    HashNode<K, V> node = new HashNode<>(hash, key, value);
    
    //비어있을 때
    if(table[index] == null){
        table[index] = node;
        size++;

    //비어있지 않을 때
    }else{
        HashNode<K, V> current = (HashNode<K, V>) table[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return current.getValue();
            }
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }
    return node.getValue();
  }


  @Override
  public void remove(K key) {
    if(size == 0){
        throw new IllegalStateException();
    }
    if (key == null) {
        throw new IllegalArgumentException();
    }

    int hash = key.hashCode() % DEFAULT_CAPACITY;
    int index = hash;
    HashNode<K, V> current = (HashNode<K, V>) table[hash];

    //0번 인덱스
    if (current.getHash() == key.hashCode()) {
        table[index] = current.getNext();
        size--;
        return;
    }
    //이후
    while (current != null) {
        if (current.getHash() == hash) {
            table[index] = current.getNext();
            size--;
            return;
        }
        current = current.getNext();
    }
  }

  @Override
  public int size() {
    return size;
  }
}
