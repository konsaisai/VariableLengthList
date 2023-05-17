package org.example;

public interface VariableLengthList {
    int count();
    boolean isEmpty();
    int get(int index);
    String toString();
    void add(int value);
    void addAll(int[] newElements);
    void update(int index, int newElement);
    void remove(int index);
}
