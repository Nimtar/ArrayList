package com.netcracker.infotech;

public interface IUncArray<T> {
    IUncArray insert(int index, T value);

    IUncArray add(T value);

    IUncArray sort(UncComparator<T> comparator);

    IUncArray remove(int index);

    T get(int index);

    IUncArray set(int index, T value);
}
