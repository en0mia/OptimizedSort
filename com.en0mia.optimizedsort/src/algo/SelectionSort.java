/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;

/*
 * Selection sort.Sort implementation.
 * inPlace: TRUE
 * stable: FALSE
 *
 * Average Time Complexity: n^2
 */
public class SelectionSort<Type extends Comparable<Type>> implements AlgoInterface<Type> {
    protected final Type[] input;

    public SelectionSort(Type[] input) {
        this.input = Arrays.copyOf(input, input.length);
    }

    @Override
    public void sort() {
        for (int i = 0; i < this.input.length; i++) {
            int min = i;

            for (int j = (i+1); j < this.input.length; j++) {
                if (this.input[min].compareTo(this.input[j]) > 0) {
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
    public Type[] getSorted() {
        return this.input;
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
