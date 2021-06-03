package structure.proxyMode.dynamicProxy;

/**
 * @author timothy
 * @data 2021年05月28日 5:48 下午
 */
public class XiaoMing implements Person {


    @Override
    public void findTeacher() {
        System.out.println("符合 小明 要求的老师");
    }

    public void buyInsure(){}
}
