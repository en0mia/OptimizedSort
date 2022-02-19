/*
    @author: Simone Nicol <en0mia.dev@gmail.com>
    @created: 17/02/22
    @copyright: Check the repository license.
*/

package algo;

public interface AlgoInterface<Type extends Comparable<Type>> {
    void sort();
    Type [] getSorted();
    boolean isStable();
    boolean isInPlace();
    int compare(Type a, Type b);
}
