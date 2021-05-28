package action.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author timothy
 * @data 2021年05月26日 6:28 下午
 */
public interface People {

    List<String> arr = new ArrayList<>();

    void add(String name);

    void remove(String name);

    Iterator getIterator();
}
