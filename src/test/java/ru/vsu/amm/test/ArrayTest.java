package ru.vsu.amm.test;

import org.junit.Before;
import org.junit.Test;
import ru.vsu.amm.Array;
import ru.vsu.amm.AscendingComparator;
import ru.vsu.amm.Comparator;
import ru.vsu.amm.DescendingComparator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayTest {
    private Array<Integer> tester;

    @Before
    public void initializeUncArray () {
        tester = new Array<>();
        for (int i = 0; i < 500_000; i++) {
            tester.add(i);
        }
    }

    @Test
    public void arrayShouldContainValueAtPosition () {
        int index = 0;
        Integer value = 5;
        assertEquals("At position " + index + " should be number " + value,
            value, tester.insert(index, value).get(index));

        index = tester.getLength();
        assertEquals("At position " + index + " should be number " + value,
            value, tester.insert(index, value).get(index));

        System.out.println("Test Insertion. Passed.");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void exceptionShouldBeErasedIfIndexTooBig () {
        int index = tester.getLength() + 1;
        final Integer value = 42;
        tester.insert(index, value).get(index);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void exceptionShouldBeErasedIfIndexLessThenZero () {
        int index = -1;
        final Integer value = 42;
        tester.insert(index, value).get(index);
    }

    @Test
    public void arrayShouldContainValueAtTheEnd () {
        final Integer value = 42;
        assertEquals("At last position should be " + value, value,
            tester.add(value).get(tester.getLength() - 1));
        System.out.println("Test Adding. Passed");
    }

    @Test
    public void arrayShouldBeShorterAfterRemovingElement () {
        int expectedLength = tester.getLength() - 1;
        int actualLength = tester.remove(0).getLength();
        assertEquals(expectedLength, actualLength);

        assertEquals(tester.getLength() - 1,
            tester.remove(tester.getLength() - 1).getLength());

        System.out.println("Test Removing. Passed");
    }

    @Test
    public void arrayShouldBeSortedDescending () {
        Comparator<Integer> comparator = new DescendingComparator();

        int length = tester.getLength();
        Map<Integer, Integer> map = makeMap(tester);
        tester.sort(comparator);
        Map<Integer, Integer> mapOfSorted = makeMap(tester);

        boolean sorted =
            length == tester.getLength() && isSame(map, mapOfSorted)
                && isSorted(tester, comparator);

        assertTrue("Array should be sorted", !sorted);
        System.out.println("Test Sorting 1. Passed");
    }

    @Test
    public void arrayShouldBeSortedAscending () {
        Comparator<Integer> comparator = new AscendingComparator();

        int length = tester.getLength();
        Map<Integer, Integer> map = makeMap(tester);
        tester.sort(comparator);
        Map<Integer, Integer> mapOfSorted = makeMap(tester);

        boolean sorted =
            length == tester.getLength() && isSame(map, mapOfSorted)
                && isSorted(tester, comparator);

        assertTrue("Array should be sorted", sorted);

        System.out.println("Test sorting 2. Passed");
    }

    private boolean isSame (Map<Integer, Integer> map,
        Map<Integer, Integer> mapOfSorted) {
        for (Integer a : map.keySet()) {
            if (!map.get(a).equals(mapOfSorted.getOrDefault(a, -1))) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> makeMap (Array a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tester.getLength(); i++) {
            map.put(tester.get(i), map.getOrDefault(i, 0) + 1);
        }
        return map;
    }

    private <R> boolean isSorted (Array<R> uncArray, Comparator<R> comparator) {
        for (int i = 1; i < uncArray.getLength(); i++) {
            if (comparator.compare(uncArray.get(i - 1), uncArray.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
