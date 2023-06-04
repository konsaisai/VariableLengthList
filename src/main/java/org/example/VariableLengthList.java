package org.example;

public interface VariableLengthList {
    int count();
    boolean isEmpty();
    int get(int index);
    void add(int value);
    void addAll(int[] newElements);
    void update(int index, int newElement);
    void remove(int index);
    static boolean equals(VariableLengthList list1, VariableLengthList list2) {
        //return (source.toString().equals(destination.toString()))だと全部の要素を比較してしまい効率が悪い
        if (list1.count() != list2.count()) return false;
        for (int i = 0; i < list1.count(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
