package org.example;

import java.util.Arrays;

//https://gist.github.com/athos/3f9a10c2ed377289061f86c7c670f00e
public class VariableLengthList {
    private int size;
    private int [] elements;

    public void VariableLengthList() {
        this.size = 0;
        this.elements = new int[1];
    }

    public void VariableLengthList(int init) {
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
        String[] strArray = new String[this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            strArray[i] = String.valueOf(this.elements[i]);
        }
        return Arrays.toString(strArray);
    }

}
