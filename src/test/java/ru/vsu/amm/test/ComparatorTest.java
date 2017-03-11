package ru.vsu.amm.test;

import org.junit.Test;
import ru.vsu.amm.AscendingComparator;
import ru.vsu.amm.DescendingComparator;
import ru.vsu.amm.Comparator;

import static org.junit.Assert.assertTrue;

public class ComparatorTest {
    @Test
    public void lesserShouldBeLess () {
        Comparator<Integer> comparator = new AscendingComparator();

        assertTrue(comparator.compare(2, 5) < 0);
        assertTrue(comparator.compare(5, 5) == 0);
        assertTrue(comparator.compare(5, 2) > 0);

        System.out.println("Ascending comparator test passed.");
    }

    @Test
    public void biggerShouldBeLess () {
        Comparator<Integer> comparator = new DescendingComparator();

        assertTrue(comparator.compare(2, 5) > 0);
        assertTrue(comparator.compare(5, 5) == 0);
        assertTrue(comparator.compare(5, 2) < 0);

        System.out.println("Descending comparator test passed");
    }
}
