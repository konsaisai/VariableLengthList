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

    public int add(int x, int y) {
        return x + y;
    }

    public int get(int index) throws IndexOutOfBoundsException {
        try {
            return this.elements[index];
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
    }

    public String toString() {
        String[] strArray = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            strArray[i] = String.valueOf(this.elements[i]);
        }
        return Arrays.toString(strArray);
    }

    public void add(int element) {
        if (this.size == this.elements.length) {
            //リストの長さを２倍にして詰め直す
            int[] wkElements = new int[(size * 2)];
            System.arraycopy(this.elements, 0, wkElements, 0, this.elements.length);
            wkElements[this.size] = element;
            this.elements = wkElements;

        } else {
            //リストに追加する
            this.elements[this.size] = element;
        }
        this.size++;
    }

    public void addAll(int[] newElements) {
         for (int element: newElements) {
             add(element);
         }
    }

    public void update(int index, int newElement) throws IndexOutOfBoundsException {
        if (0 <= index && index < this.size) {
            this.elements[index] = newElement;
        } else {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (0 <= index && index < this.size) {
            for (int i = index; i < this.size - 1; i++) {
                this.elements[i] = this.elements[i + 1];
            }
            this.size--;
        } else {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
    }
}
