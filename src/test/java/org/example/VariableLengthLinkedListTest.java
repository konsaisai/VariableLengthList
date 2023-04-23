package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VariableLengthLinkedListTest {
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
}
