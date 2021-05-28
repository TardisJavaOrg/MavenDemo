package action.iterator;

import java.util.List;

/**
 * @author timothy
 * @data 2021年05月24日 5:21 下午
 * 具体迭代器
 */
public class ConcreteIterator<T> implements Iterator<T> {

    // 维护对象数组
    private List<T> arr;

    // 维护一个索引
    private int index = -1;

    public ConcreteIterator(List<T> arr) {
        this.arr = arr;
    }

    @Override
    public T first() {
        return arr.get(0);
    }

    /**
     * 获取下一个，如果有才获取
     */
    @Override
    public T next() {
        if (this.hasNext()) {
            return arr.get(++index);
        }
        return null;
    }

    /**
     * 是否有下一个
     */
    @Override
    public boolean hasNext() {
        if (index < arr.size() - 1) {
            return true;
        }
        return false;
    }
}
