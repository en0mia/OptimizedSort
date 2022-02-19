/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 19/02/22
    @copyright: Check the repository license.
*/

package algo;

import java.util.Comparator;

public abstract class AbstractAlgo<Type extends Comparable<Type>> implements AlgoInterface<Type> {
    protected Comparator<Type> comparator = null;
    protected Type[] input;

    @Override
    public int compare(Type a, Type b) {
        if (this.comparator != null) {
            return this.comparator.compare(a, b);
        }

        return a.compareTo(b);
    }

    @Override
    public Type[] getSorted() {
        return this.input;
    }
}
