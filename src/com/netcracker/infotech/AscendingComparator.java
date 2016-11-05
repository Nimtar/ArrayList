package com.netcracker.infotech;

public class AscendingComparator implements UncComparator {

    @Override
    public int compare(int left, int right) {
        return left > right ? 1 : left == right ? 0 : -1;
    }
}
