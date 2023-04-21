package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class VariableLengthListArrayTest {

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

}