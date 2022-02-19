/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Shell Sort implementation using original Shell's sequence.
 * inPlace: TRUE
 * stable: FALSE
 *
 * Average Time Complexity: nlog(n)
 */
public class ShellSort<Type extends Comparable<Type>> extends AbstractAlgo<Type> {
    public ShellSort(Type[] input) {
        this.input = Arrays.copyOf(input, input.length);
    }

    public ShellSort(Type []input, Comparator<Type> comparator) {
        // Safe copy.
        this.input = Arrays.copyOf(input, input.length);
        this.comparator = comparator;
    }

    @Override
    public void sort() {
        int length = this.input.length;
        for (int g = length/2; g > 0; g = g/2) {
            for (int i = g; i < length; i++) {
                int j = i;
                while (j >= g && this.compare(this.input[j - g], this.input[i]) > 0) {
                    this.input[j] = this.input[j - g];
                    j -= g;
                }

                this.input[j] = this.input[i];
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
