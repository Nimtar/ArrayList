package com.netcracker.infotech;

public class DescendingComparator implements UncComparator<Integer> {
    @Override
    public int compare(Integer left, Integer right) {
        return left < right ? 1 : left.equals(right) ? 0 : -1;
    }
}
