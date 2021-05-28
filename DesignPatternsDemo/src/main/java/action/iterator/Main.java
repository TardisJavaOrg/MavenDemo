package action.iterator;

/**
 * @author timothy
 * @data 2021年05月26日 6:22 下午
 * 迭代器模式
 */
public class Main {
    public static void main(String[] args) {
        People users = new Student();
        users.add("tardis");
        users.add("timothy");
        Iterator<String> iterator = users.getIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next.toString());
        }
    }
}
