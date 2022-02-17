/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;
import java.util.Random;

/*
 * Quick sort.Sort implementation.
 * inPlace: TRUE
 * stable: FALSE
 *
 * Average Time Complexity: nlog(n)
 */
public class QuickSort<Type extends Comparable<Type>> implements AlgoInterface<Type> {
    protected final Type []input;

    public QuickSort(Type[] input) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
    }

    public void sort() {
        // Shuffle needed for performance guarantee.
        this.shuffle();
        this.sortRecursive(0, this.input.length - 1);
    }

    protected void sortRecursive(int low, int high) {
        if (high <= low) {
            return;
        }

        int j = this.partition(low, high);
        this.sortRecursive(low, j - 1);
        this.sortRecursive(j + 1, high);
    }

    protected void shuffle() {
        Random r = new Random();

        for (int i = 0; i < this.input.length; i++) {
            this.swap(i, r.nextInt(this.input.length));
        }
    }

    protected int partition(int low, int high) {
        int i = low;
        int j = high + 1;

        while (true) {
            while (this.input[++i].compareTo(this.input[low]) < 0) {
                if (i == high) {
                    break;
                }
            }

            while (this.input[low].compareTo(this.input[--j]) < 0) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            this.swap(i, j);
        }

        this.swap(low, j);
        return j;
    }

    protected void swap(int a, int b) {
        Type tmp = this.input[a];
        this.input[a] = this.input[b];
        this.input[b] = tmp;
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
