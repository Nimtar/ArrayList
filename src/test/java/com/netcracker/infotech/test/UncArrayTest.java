package com.netcracker.infotech.test;

import com.netcracker.infotech.AscendingComparator;
import com.netcracker.infotech.DescendingComparator;
import com.netcracker.infotech.UncArray;
import com.netcracker.infotech.UncComparator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UncArrayTest<T> {
    private UncArray<Integer> tester;

    @Before
    public void initializeUncArray() {
        tester = new UncArray<>();
        for (int i = 0; i < 500_000; i++) {
            tester.add(i);
        }
    }

    @Test
    public void arrayShouldContainValueAtPosition() {
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
    public void exceptionShouldBeErasedIfIndexTooBig() {
        int index = tester.getLength() + 1;
        Integer value = 42;
        tester.insert(index, value).get(index);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void exceptionShouldBeErasedIfIndexLessThenZero() {
        int index = -1;
        Integer value = 42;
        tester.insert(index, value).get(index);
    }

    @Test
    public void arrayShouldContainValueAtTheEnd() {
        Integer value = 42;
        assertEquals("At last position should be " + value, value,
                tester.add(value).get(tester.getLength() - 1));
        System.out.println("Test Adding. Passed");
    }

    @Test
    public void arrayShouldBeShorterAfterRemovingElement() {
        int expectedLength = tester.getLength() - 1;
        int actualLength = tester.remove(0).getLength();
        assertEquals(expectedLength, actualLength);

        assertEquals(
                tester.getLength() - 1,
                tester.remove(tester.getLength() - 1).getLength()
        );

        System.out.println("Test Removing. Passed");
    }

    @Test
    public void arrayShouldBeSorted() {
        UncComparator<Integer> uncComparator = new DescendingComparator();
        assertTrue("Array should be sorted", isSorted(tester.sort(uncComparator), uncComparator));

        uncComparator = new AscendingComparator();
        assertTrue("Array should be sorted", isSorted(tester.sort(uncComparator), uncComparator));

        System.out.println("Test Sorting. Passed");
    }

    private <R> boolean isSorted(UncArray<R> uncArray, UncComparator<R> comparator) {
        for (int i = 1; i < uncArray.getLength(); i++) {
            if (comparator.compare(uncArray.get(i - 1), uncArray.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
