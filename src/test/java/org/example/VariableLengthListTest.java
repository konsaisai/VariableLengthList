package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VariableLengthListTest {
    @Test
    @DisplayName("CountMethodTest ⇨ 0")
    public void testCount_0() {
        var list = new VariableLengthLinkedList();
        assertEquals(0, list.count());
    }

    @Test
    @DisplayName("CountMethodTest ⇨ 3")
    public void testCount_3() {
        var list = new VariableLengthLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.count());
    }

    @Test
    @DisplayName("isEmpty")
    public void isEmpty() {
        var list = new VariableLengthLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("isNotEmpty")
    public void isNotEmpty() {
        var list = new VariableLengthLinkedList();
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("get")
    public void getElement() {
        var list = new VariableLengthLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () ->list.get(0));
        list.add((1));
        list.add((2));
        list.add((3));
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 2);
        assertEquals(list.get(2), 3);
        assertThrows(IndexOutOfBoundsException.class, () ->list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () ->list.get(4));

    }

    @Test
    @DisplayName("ToString")
    public void ToString() {
        var list = new VariableLengthLinkedList();
        assertEquals("[]", list.toString());
        list.add((1));
        list.add((2));
        list.add((3));
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    @DisplayName("addAll")
    public void addAll() {
        var list = new VariableLengthLinkedList();
        list.addAll(new int[] {1, 2, 3, 4, 10});
        assertEquals("[1, 2, 3, 4, 10]", list.toString());
    }

    @Test
    @DisplayName("update")
    public void update() {
        var list = new VariableLengthLinkedList();
        list.addAll(new int[] {1, 2, 3, 4, 10});
        list.update(1, 5);
        assertEquals("[1, 5, 3, 4, 10]", list.toString());
    }

    @Test
    @DisplayName("remove")
    public void remove() {
        var list = new VariableLengthLinkedList();
        list.addAll(new int[] {1, 2, 3, 4, 10});
        list.remove(1);
        assertEquals("[1, 3, 4, 10]", list.toString());
        list.remove(0);
        assertEquals("[3, 4, 10]", list.toString());
        list.remove(2);
        assertEquals("[3, 4]", list.toString());
    }

    //@Testを記載したメソッドのみ実行される
    //@Test
    @Test
    @DisplayName("CountMethodTest")
    public void testCount() {
        var list = new VariableLengthArrayList();
        assertEquals(0, list.count());
    }

    @Test
    @DisplayName("isEmptyTest")
    public void testIsEmpty() {
        var list = new VariableLengthArrayList();
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("add & get & count & toString")
    public void testAddAndGet() {
        var list = new VariableLengthArrayList();
        list.add(2);
        list.add(3);
        list.add(8);
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(8, list.get(2));
        assertEquals("[2, 3, 8]", list.toString());
        assertEquals(3, list.count());
    }

    @Test
    @DisplayName("OutOfBounds")
    void testOutOfBounds() {
        var list = new VariableLengthArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    @DisplayName("AddAllTest")
    void testAddAll() {
        var list = new VariableLengthArrayList(3);
        list.addAll(new int[] {1, 2, 3, 4, 10});
        assertEquals("[1, 2, 3, 4, 10]", list.toString());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(10, list.get(4));
        assertEquals(5, list.count());
    }

    @Test
    @DisplayName("UpdateTest")
    void testUpdate() {
        var list = new VariableLengthArrayList();
        list.addAll(new int[] {1, 2, 3, 4, 10});
        assertEquals(10, list.get(4));
        list.update(4, 39);
        assertEquals(39, list.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.update(5, 20));
        assertThrows(IndexOutOfBoundsException.class, () -> list.update(-1, 20));
    }

    @Test
    @DisplayName("RemoveTest")
    void removeTest() {
        var list = new VariableLengthArrayList();
        list.addAll(new int[] {1, 2, 3, 4, 10, 11, 12, 13});
        assertEquals(8, list.count());
        list.remove(6);
        assertEquals("[1, 2, 3, 4, 10, 11, 13]", list.toString());
        list.remove(2);
        assertEquals("[1, 2, 4, 10, 11, 13]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void equalsTest(){
        var arrayList = new VariableLengthArrayList();
        var linkedList = new VariableLengthLinkedList();
        arrayList.addAll(new int[] {1, 2, 3, 4, 10, 11, 12, 13});
        linkedList.addAll(new int[] {1, 2, 3, 4, 10, 11, 12, 13});
        assertTrue(Controller.equals(arrayList, linkedList));

    }

}
