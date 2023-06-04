package org.example;

//https://gist.github.com/athos/3f9a10c2ed377289061f86c7c670f00e
public class VariableLengthArrayList implements VariableLengthList {
    private int size;
    private int [] elements;

     VariableLengthArrayList() {
        this.size = 0;
        this.elements = new int[1];
    }

    VariableLengthArrayList(int init) {
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
         //try catchではなく自身でエラー処理を行うのは、TryCatchに依存しているとどういう時にエラーになるのかが見えにくくなるため（自身でコントロール）
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException("Error!!!IndexOutOfBounds");
        }
        return this.elements[index];
    }

    @Override
    public String toString() {
         // 文字列の結合は+だと毎回文字列を作成してしまうためStringBuilderを使用する(速度を速くする)
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]);
            if (i < this.size -1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(int value) {
        if (this.size == this.elements.length) {
            //リストの長さを２倍にして詰め直す
            int[] wkElements = new int[(size * 2)];
            System.arraycopy(this.elements, 0, wkElements, 0, this.elements.length);
            this.elements = wkElements;
        }
        //リストに追加する
        this.elements[this.size] = value;
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

    @Override
    public boolean equals(Object obj) {
        return VariableLengthList.equals(this, (VariableLengthList)obj);
    }
}
