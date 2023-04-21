package org.example;

import java.util.Arrays;

//https://gist.github.com/athos/3f9a10c2ed377289061f86c7c670f00e
public class VariableLengthList {
    private int size;
    private int [] elements;

     VariableLengthList() {
        this.size = 0;
        this.elements = new int[1];
    }

    VariableLengthList(int init) {
        this.size = 0;
        this.elements = new int[init];
    }

    public int count() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        return this.elements[index];
    }

    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            str.append(this.elements[i]);
            if (i < this.size -1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    public void add(int element) {
        if (this.size == this.elements.length) {
            //リストの長さを２倍にして詰め直す
            int[] wkElements = new int[(size * 2)];
            System.arraycopy(this.elements, 0, wkElements, 0, this.elements.length);
            this.elements = wkElements;
        }
        //リストに追加する
        this.elements[this.size] = element;
        this.size++;
    }

    public void addAll(int[] newElements) {
         for (int element: newElements) {
             add(element);
         }
    }

    public void update(int index, int newElement) throws IndexOutOfBoundsException {
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        this.elements[index] = newElement;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
    }
}
