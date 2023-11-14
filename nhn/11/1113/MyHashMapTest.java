//1113(월) -> HashMap, Test 구현
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyHashMapTest {

  @Test
  void clear() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "a");
    myHashMap.clear();

    assertEquals(0, myHashMap.size());
  }

  @Test
  void containsKey() {

    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "value");

    boolean result = myHashMap.containsKey(1);
    boolean result2 = myHashMap.containsKey(2);

    assertAll(
            () -> assertTrue(result),
            () -> assertFalse(result2)
    );

  }

  @Test
  void containsValue() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(2, "value");

    boolean result = myHashMap.containsValue("value");
    boolean result2 = myHashMap.containsValue("value2");

    assertAll(
            () -> assertTrue(result),
            () -> assertFalse(result2)
    );
  }

  @Test
  void get() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(3, "value");
    
    assertEquals("value", myHashMap.get(3));
  }

  @Test
  void isEmpty() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "value");
    myHashMap.remove(1);

    assertTrue(myHashMap.isEmpty());

  }

  @Test
  void put() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "value");
    myHashMap.put(2, "value");
    myHashMap.put(2, "value2");
    myHashMap.put(3, "value3");
    
    assertAll(
            () -> assertEquals("value2", myHashMap.get(2)),
            () -> assertEquals("value3", myHashMap.get(3)),
            () -> assertEquals(3, myHashMap.size())
    );
  }

  @Test
  void remove() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "value");
    myHashMap.put(1, "value2");
    myHashMap.put(2, "value2");
    myHashMap.remove(1);

    assertEquals(1, myHashMap.size());
  }

  @Test
  void size() {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    myHashMap.put(1, "value");
    myHashMap.put(2, "value");
    
    boolean result = myHashMap.isEmpty();

    assertAll(
            () -> assertFalse(result),
            () -> assertEquals(2, myHashMap.size())
    );
  }
}