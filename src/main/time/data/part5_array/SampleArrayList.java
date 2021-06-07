package main.time.data.part5_array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 仿ArrayList（可扩容数组）实现
 */
public class SampleArrayList<T> {

    /**
     * 测试
     */
    public static void main(String[] args) {
        SampleArrayList<String> list = new SampleArrayList<>();
        list.add("num1");
        list.add("num2");
        list.add("num3");
        list.add("num4");
        list.addFirst("ans1");
        list.addFirst("ans2");
        list.addFirst("ans3");
        list.addFirst("ans4");
        list.add("Microsoft!", 4);
        list.printAll();

        list.removeFirst();
        list.removeFirst();
        list.removeEnd();
        list.removeEnd();
        list.removeIndex(2);
        list.printAll();
    }

    private static final int DEFAULT_CAPACITY = 4;

    private Object[] mData;
    private int mCapacity;
    private int mSize;

    public void printAll() {
        System.out.println(toString());
    }

    public SampleArrayList() {
        mData = new Object[DEFAULT_CAPACITY];
        mCapacity = DEFAULT_CAPACITY;
        mSize = 0;
    }

    public SampleArrayList(int capacity) {
        mData = new Object[capacity];
        mCapacity = capacity;
        mSize = 0;
    }

    public void add(T value, int toIndex) {
        if (toIndex < 0 || toIndex > mSize) {
            throw new IndexOutOfBoundsException("数组下标错误");
        }
        checkAndExpansion();
        move(toIndex);
        mData[toIndex] = value;
        mSize++;
    }

    public void addFirst(T number) {
        add(number, 0);
    }

    public void add(T number) {
        add(number, mSize);
    }

    public void removeIndex(int index) {
        if (index < 0 || index > mSize) {
            throw new IndexOutOfBoundsException("数组下标错误");
        }
        moveDelete(index);
        mSize--;
    }

    public void removeFirst() {
        removeIndex(0);
    }

    public void removeEnd() {
        removeIndex(mSize - 1);
    }

    private void checkAndExpansion() {
        if (mSize + 1 >= mCapacity) {
            Object[] temp = new Object[mCapacity * 2];
            if (mCapacity >= 0) System.arraycopy(mData, 0, temp, 0, mCapacity);
            mData = temp;
            mCapacity *= 2;
        }
    }

    private void move(int start) {
        if (mSize + 1 - start >= 0)
            System.arraycopy(mData, start, mData, start + 1, mSize + 1 - start);
    }

    private void moveDelete(int start) {
        if (mSize - 1 - start >= 0)
            System.arraycopy(mData, start + 1, mData, start, mSize - 1 - start);
    }

    @Override
    public String toString() {
        if (mSize == 0 && mData == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < mSize - 1; i++) {
            builder.append(mData[i]);
            if (i < mSize - 2) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
