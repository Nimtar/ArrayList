package ru.vsu.amm;

@FunctionalInterface
public interface Comparator<T> {
    int compare (T left, T right);
}
