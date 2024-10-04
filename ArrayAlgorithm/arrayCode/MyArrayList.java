package arrayCode;

import java.util.NoSuchElementException;

public class MyArrayList<E> {


    private static final int INIT_CAP = 1;
    private E[] data;
    private int size;


    public MyArrayList() {
        this(INIT_CAP);
    }


    public MyArrayList(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
        this.size = 0;
    }


    public void addLast(E e) {
        int cap = data.length;
        if (size == cap) {
            resize(2 * size);
        }
        data[size] = e;
        size++;
    }


    public void add(int index, E e) {
        checkPositionIndex(index);

        int cap = data.length;
        if (cap == size) {
            resize(2 * size);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    public void addFirst(E e) {
        add(0, e);
    }


    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deletedVal = data[size - 1];
        data[size - 1] = null;
        size--;
        return deletedVal;
    }


    public E remove(int index) {
        checkPositionIndex(index);
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deletedVal = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        data[size - 1] = null;
        size--;
        return deletedVal;
    }


    public E removeFirst() {
        return remove(0);
    }


    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }


    public E set(int index, E e) {
        checkElementIndex(index);

        E oldVal = data[index];
        data[index] = e;
        return oldVal;
    }


    //工具方法
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);

        data = temp;
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    private void checkElementIndex(int index) {
        if (!(isElementIndex(index))) {
            throw new IndexOutOfBoundsException(STR."Index:\{index},Size:\{size}");
        }
    }


    private void checkPositionIndex(int index) {
        if (!(isPositionIndex(index))) {
            throw new IndexOutOfBoundsException(STR."Index:\{index},Size:\{size}");
        }
    }


}
