package com.netcracker.infotech;

public interface IUncArray {
    IUncArray insert(int index, int value);

    IUncArray add(int value);

    IUncArray sort(UncComparator comparator);

    IUncArray remove(int index);

    int get(int index);

    IUncArray set(int index, int value);
}
