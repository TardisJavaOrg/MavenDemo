package action.iterator;

/**
 * @author timothy
 * @data 2021年05月26日 6:28 下午
 */
public class Student implements People{

    @Override
    public void add(String name) {
        arr.add(name);
    }

    @Override
    public void remove(String name) {
        arr.remove(name);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator<String>(arr);
    }
}
