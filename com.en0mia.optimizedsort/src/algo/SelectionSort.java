/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Selection sort.Sort implementation.
 * inPlace: TRUE
 * stable: FALSE
 *
 * Average Time Complexity: n^2
 */
public class SelectionSort<Type extends Comparable<Type>> extends AbstractAlgo<Type> {
    public SelectionSort(Type[] input) {
        this.input = Arrays.copyOf(input, input.length);
    }

    public SelectionSort(Type[] input, Comparator<Type> comparator) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
        this.comparator = comparator;
    }

    @Override
    public void sort() {
        for (int i = 0; i < this.input.length; i++) {
            int min = i;

            for (int j = (i+1); j < this.input.length; j++) {
                if (this.compare(this.input[min], this.input[j]) > 0) {
                    min = j;
                }
            }

            if (min != i) {
                Type k = this.input[min];
                this.input[min] = this.input[i];
                this.input[i] = k;
            }
        }
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
