/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package test;

import algo.*;
import sort.Sort;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    Integer []array;
    Random random = new Random();
    final static int LENGTH = 10000;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Set the array to {LENGTH} random numbers;
        this.array = new Integer[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            this.array[i] = random.nextInt(LENGTH);
        }
    }

    @org.junit.jupiter.api.Test
    void testConstructorException() {
        assertThrows(IllegalArgumentException.class, () -> new Sort<>(null));

        assertThrows(IllegalArgumentException.class, () -> new Sort<>(new Integer[]{1, null}));

        assertThrows(IllegalArgumentException.class, () -> new Sort<>(new Integer[0]));
    }

    @org.junit.jupiter.api.Test
    void testSetAlgorithm() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sort<Integer> sort = new Sort<>(new Integer[]{1, 2, 3});
            sort.setAlgorithm("");
        });
    }

    @org.junit.jupiter.api.Test
    void testSelectionSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("selection");
        assertEquals(SelectionSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testHeapSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("heap");
        assertEquals(HeapSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testInsertionSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("insertion");
        assertEquals(InsertionSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testMergeSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("merge");
        assertEquals(MergeSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testQuickSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("quick");
        assertEquals(QuickSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testShellSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        sort.setAlgorithm("shell");
        assertEquals(ShellSort.class, sort.getAlgorithm().getClass());
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testAutoAlgoSort() {
        Sort<Integer> sort = new Sort<>(this.array);
        this.array = sort.sort();

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testAutoAlgoStableSort() {
        Sort<Integer> sort = new Sort<>(this.array, false, true);
        this.array = sort.sort();

        assertTrue(sort.getAlgorithm().isStable());

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testAutoAlgoInPlaceSort() {
        Sort<Integer> sort = new Sort<>(this.array, true, false);
        this.array = sort.sort();

        assertTrue(sort.getAlgorithm().isInPlace());

        assertTrue(this.isSorted());
    }

    @org.junit.jupiter.api.Test
    void testAutoAlgoStableInPlaceSort() {
        Sort<Integer> sort = new Sort<>(this.array, true, true);
        this.array = sort.sort();

        assertTrue(sort.getAlgorithm().isStable() && sort.getAlgorithm().isInPlace());

        assertTrue(this.isSorted());
    }

    boolean isSorted() {
        for (int i = 1; i < LENGTH; i++) {
            if (this.array[i] < this.array[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
