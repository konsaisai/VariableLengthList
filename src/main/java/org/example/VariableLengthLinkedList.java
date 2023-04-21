package org.example;

class Element {
    int element;
    Element next;
}

public class VariableLengthLinkedList {
    private Element head;
    private Element tail;
    //TODO

    VariableLengthLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        boolean bNext = true;
        int count = 0;
        Element wkEle = this.head.next;
        while (bNext) {
            if (wkEle.next == null) {
                count ++;
            } else {
                bNext = false;
            }
        }
        return count;
    }


}