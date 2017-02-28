import com.netcracker.infotech.AscendingComparator;
import com.netcracker.infotech.DescendingComparator;
import com.netcracker.infotech.UncComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ComparatorTest {
    @Test
    public void lesserShouldBeLess() {
        UncComparator comparator = new AscendingComparator();

        assertTrue(comparator.compare(2, 5) < 0);
        assertTrue(comparator.compare(5, 5) == 0);
        assertTrue(comparator.compare(5, 2) > 0);

        System.out.println("Ascending comparator test passed.");
    }

    @Test
    public void biggerShouldBeLess() {
        UncComparator comparator = new DescendingComparator();

        assertTrue(comparator.compare(2, 5) > 0);
        assertTrue(comparator.compare(5, 5) == 0);
        assertTrue(comparator.compare(5, 2) < 0);

        System.out.println("Descending comparator test passed");
    }
}
