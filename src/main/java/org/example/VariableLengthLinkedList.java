package org.example;

class Element {
    int element;
    Element next;
}

public class VariableLengthLinkedList implements VariableLengthList {
    private Element head;
    private Element tail;

    VariableLengthLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        if (this.head == null) {
            return 0;
        }
        int count = 1;
        Element element = this.head;
        while (element.next != null) {
            element = element.next;
            count ++;
        }
        return count;
    }

    public boolean isEmpty() {return this.head == null;}

    public int get(int index) throws IndexOutOfBoundsException {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        int i = 0;
        Element element = this.head;
        while (i < index && element.next != null) {
            element = element.next;
            i ++;
        }
        if (i != index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        return element.element;
    }

    @Override
    public String toString() {
        // 文字列の結合は+だと毎回文字列を作成してしまうためStringBuilderを使用する(速度を速くする)
        StringBuilder sb = new StringBuilder("[");
        Element element = new Element();
        element = this.head;
        while (element != null) {
            sb.append(element.element);
            element = element.next;
            if (element != null ) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(int value) {
        Element element = new Element();
        element.element = value;

        // headがnullの場合
        if (this.head == null) {
            this.head = element;
        } else {
            this.tail.next = element;
        }
        this.tail = element;
    }

    @Override
    public void addAll(int[] newElements) {
        for (int element: newElements) {
            add(element);
        }
    }

    @Override
    public void update(int index, int newElement) throws IndexOutOfBoundsException {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        int i = 0;
        Element element = this.head;
        while (i < index && element.next != null) {
            element = element.next;
            i ++;
        }
        if (i != index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        element.element = newElement;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }

        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        int i = 0;
        Element element = this.head;
        while (i < index - 1 && element.next != null) {
            element = element.next;
            i ++;
        }
        if (i != index - 1) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }

        if (element.next.next == null) {
            this.tail = element;
            element.next = null;
        } else {
            element.next = element.next.next;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return VariableLengthList.equals(this, (VariableLengthList)obj);
    }
}