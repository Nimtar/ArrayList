package ru.vsu.amm;

public class DescendingComparator implements Comparator<Integer> {
    @Override
    public int compare (Integer left, Integer right) {
        return left < right ? 1 : left.equals(right) ? 0 : -1;
    }
}
