import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Jinny Eo
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void withNullTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // withNullTest()

  @Test
  public void stringTest() {
    String[] original = { "charlie", "alpha", "bravo", "delta", "foxtrot" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest()

@Test
  public void integerTest() {
    Integer[] original = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // integerTest()

  @Test
  public void withDupTest() {
    Integer[] original = {3, 4, 2, 1, 5, 4, 1};
    Integer[] expected = {1, 1, 2, 3, 4, 4, 5};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // withDupTest()

  @Test
  public void sortSortedTest() {
    Integer[] original = {1, 2, 3, 4, 5};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // alreadySortedTest()

} // class SortTester

