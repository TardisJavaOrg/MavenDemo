package action.iterator;

/**
 * @author timothy
 * @data 2021年05月24日 5:18 下午
 */
public interface Iterator<T> {

    T first();

    T next();

    boolean hasNext();

}
