/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Heap sort.Sort implementation.
 * inPlace: TRUE
 * stable: FALSE
 *
 * Average Time Complexity: nlog(n)
 */
public class HeapSort<Type extends Comparable<Type>> extends AbstractAlgo<Type> {
    public HeapSort(Type []input) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
    }

    public HeapSort(Type []input, Comparator<Type> comparator) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
        this.comparator = comparator;
    }

    @Override
    public void sort() {
        int n = this.input.length;

        // Build the heap using heapify
        for (int i = n/2 - 1; i >= 0; i--) {
            this.heapify(n, i);
        }

        // Extract the maximum element and re-heapify
        for (int i = n - 1; i >= 0; i--) {
            this.swap(0, i);
            this.heapify(i, 0);
        }
    }

    protected void heapify(int n, int i) {
        int root = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && this.compare(this.input[left], this.input[root]) > 0) {
            root = left;
        }

        if (right < n && this.compare(this.input[right], this.input[root]) > 0) {
            root = right;
        }

        if (root != i) {
            this.swap(i, root);
            heapify(n, root);
        }
    }

    protected void swap(int a, int b) {
        Type tmp = this.input[a];
        this.input[a] = this.input[b];
        this.input[b] = tmp;
    }

    @Override
    public boolean isStable() {
        return false;
    }

    @Override
    public boolean isInPlace() {
        return true;
    }
}
