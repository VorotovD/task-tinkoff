import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ShelfTest {
    private Shelf getShelf() {
        return new Shelf("dcacd");
    }

    @Test
    public void getTreeMapShelfTest() {
        TreeMap<Character, TreeSet<Integer>> expected = new TreeMap<>();
        TreeSet<Integer> o = new TreeSet<>();
        TreeSet<Integer> p = new TreeSet<>();
        TreeSet<Integer> e = new TreeSet<>();
        TreeSet<Integer> n = new TreeSet<>();
        o.add(0);
        o.add(4);
        p.add(1);
        e.add(2);
        n.add(3);
        expected.put('o', o);
        expected.put('p', p);
        expected.put('e', e);
        expected.put('n', n);

        Shelf actionShelf = new Shelf("Openo");
        Assertions.assertEquals(expected, actionShelf.getTreeMapShelf(0, 4));
    }

    @Test
    public void getCountOperationsTest() {
        int expected = 10;
        Integer[] sequence = new Integer[2];
        sequence[0] = 0;
        sequence[1] = 4;
        Assertions.assertEquals(expected, getShelf().getCountOperations(sequence));
    }

    @Test
    public void getNextIndexTest() {
        Set<Integer> setPositionsActual = new TreeSet<>();
        setPositionsActual.add(3);
        setPositionsActual.add(1);
        Assertions.assertEquals(3, getShelf().getNextIndex(setPositionsActual, 2, 5));
    }
}

