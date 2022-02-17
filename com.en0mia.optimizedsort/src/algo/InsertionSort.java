/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;

/*
 * Insertion sort.Sort implementation.
 * inPlace: TRUE
 * stable: TRUE
 *
 * Average Time Complexity: n^2
 */
public class InsertionSort<Type extends Comparable<Type>> implements AlgoInterface<Type> {
    protected final Type[] input;

    public InsertionSort(Type []input) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
    }

    @Override
    public void sort() {
        for (int i = 1; i < this.input.length; ++i) {
            Type key = this.input[i];
            int j = i - 1;

            while (j >= 0 && (this.input[j].compareTo(key) > 0)) {
                this.input[j + 1] = this.input[j];
                j--;
            }

            this.input[j + 1] = key;
        }
    }

    @Override
    public Type[] getSorted() {
        return this.input;
    }

    @Override
    public boolean isStable() {
        return true;
    }

    @Override
    public boolean isInPlace() {
        return true;
    }
}
