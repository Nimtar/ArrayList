package com.netcracker.infotech;

import java.util.Random;

public class UncArray implements IUncArray {
    private int[] a;
    private int capacity;
    private int length;

    public UncArray() {
        this(0);
    }

    public UncArray(int capacity) {
        this.capacity = capacity < 2 ? 10 : capacity;
        a = new int[this.capacity];
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    private void qsort(int l, int r, UncComparator comparator) {
        if (l >= r) {
            return;
        }
        int p = partition(l, r, comparator);
        qsort(l, p, comparator);
        qsort(p + 1, r, comparator);
    }

    private int partition(int l, int r, UncComparator comparator) {
        int rand = new Random().nextInt(r - l + 1) + l;
        int x = a[rand];
        int i = l - 1;
        int j = r + 1;
        while (true) {
            while (comparator.compare(a[--j], x) > 0) {
            }
            while (comparator.compare(a[++i], x) < 0) {
            }
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            } else {
                return j;
            }
        }
    }

    @Override
    public UncArray insert(int index, int value) {
        if (index < 0 || length < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (capacity < length + 1) {
            reallocate();
        }
        for (int i = length; i > index; i--) {
            a[i] = a[i - 1];
        }
        a[index] = value;

        length++;

        return this;
    }

    private void reallocate() {
        int newCapacity = capacity * 3 / 2;
        int[] t = new int[newCapacity];
        for (int i = 0; i < capacity; i++) {
            t[i] = a[i];
        }
        a = t;
        capacity = newCapacity;
    }

    @Override
    public UncArray add(int value) {
        insert(length, value);
        return this;
    }

    @Override
    public UncArray sort(UncComparator comparator) {
        qsort(0, length - 1, comparator);
        return this;
    }

    @Override
    public UncArray remove(int index) {
        for (int i = index; i < length - 1; i++) {
            a[i] = a[i + 1];
        }
        length--;

        return this;
    }

    @Override
    public int get(int index) {
        if (index < 0 || length <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return a[index];
    }

    @Override
    public UncArray set(int index, int value) {
        if (index < 0 || length <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        a[index] = value;

        return this;
    }
}
