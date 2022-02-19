package sort;/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

import algo.*;

import java.util.Comparator;

public class Sort<Type extends Comparable<Type>> {
    protected Type[] input;
    protected boolean inPlace = false;
    protected boolean stable = false;
    protected AlgoInterface<Type> algorithm = null;
    protected Comparator<Type> comparator = null;

    @SuppressWarnings("")
    public Sort(Type []input) throws IllegalArgumentException {
        this.verify(input);
        this.input = input;
    }

    public Sort(Type []input, boolean inPlace, boolean stable) throws IllegalArgumentException {
        this.verify(input);
        this.input = input;
        this.inPlace = inPlace;
        this.stable = stable;
    }

    public void setComparator(Comparator<Type> comparator) {
        this.comparator = comparator;
    }

    private void verify(Type []input) throws IllegalArgumentException {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Array should be non-null and with a length > 0");
        }

        for (Type t : input) {
            if (t == null) {
                throw new IllegalArgumentException("Array's objects should not be null.");
            }
        }
    }

    public void setAlgorithm(String name) throws IllegalArgumentException {
        switch (name) {
            case "selection" -> this.algorithm = new SelectionSort<>(this.input);
            case "heap" -> this.algorithm = new HeapSort<>(this.input);
            case "insertion" -> this.algorithm = new InsertionSort<>(this.input);
            case "merge" -> this.algorithm = new MergeSort<>(this.input);
            case "quick" -> this.algorithm = new QuickSort<>(this.input);
            case "shell" -> this.algorithm = new ShellSort<>(this.input);
            default -> throw new IllegalArgumentException("Name should be a sorting algorithm name!");
        }
    }

    public Type[] sort() {
        if (this.algorithm == null) {
            if (this.inPlace) {
                // Heap sort is in place but not stable!
                this.algorithm = new HeapSort<>(this.input, this.comparator);

                if (this.stable) {
                    // Insertion sort is in place and stable!
                    this.algorithm = new InsertionSort<>(this.input, this.comparator);
                }
            } else {
                // Merge sort is stable but not in place!
                // Cutoff for tiny arrays
                if (this.input.length < 7) {
                    this.algorithm = new InsertionSort<>(this.input, this.comparator);
                } else {
                    this.algorithm = new MergeSort<>(this.input, this.comparator);
                }
            }
        }

        this.algorithm.sort();
        this.input = this.algorithm.getSorted();

        return this.input;
    }

    public AlgoInterface<Type> getAlgorithm() {
        return this.algorithm;
    }
}
