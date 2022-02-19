/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Merge sort.Sort implementation.
 * inPlace: FALSE
 * stable: TRUE
 *
 * Average Time Complexity: nlog(n)
 */
public class MergeSort<Type extends Comparable<Type>> extends AbstractAlgo<Type> {
    public MergeSort(Type []input) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
    }

    public MergeSort(Type []input, Comparator<Type> comparator) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
        this.comparator = comparator;
    }

    @Override
    public void sort() {
        this.sortRecursive(this.input, 0, this.input.length - 1);
    }

    protected void sortRecursive(Type []a, int low, int high) {
        if (high <= low) {
            return;
        }

        int middle = low + (high - low) / 2;
        this.sortRecursive(a, low, middle);
        this.sortRecursive(a, middle + 1, high);

        this.merge(a, low, middle, high);
    }

    protected void merge(Type[] a, int low, int middle, int high) {
        Type[] aux = Arrays.copyOf(a, a.length);

        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if (i > middle) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (this.compare(aux[j], aux[i]) < 0) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    @Override
    public boolean isStable() {
        return true;
    }

    @Override
    public boolean isInPlace() {
        return false;
    }
}
