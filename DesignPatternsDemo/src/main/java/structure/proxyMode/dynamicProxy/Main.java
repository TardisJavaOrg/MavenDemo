package structure.proxyMode.dynamicProxy;

/**
 * @author timothy
 * @data 2021年05月28日 5:30 下午
 */
public class Main {
    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();
        Person instance = jdkFuDao.getInstance(new XiaoMing());
        instance.findTeacher();
    }
}
