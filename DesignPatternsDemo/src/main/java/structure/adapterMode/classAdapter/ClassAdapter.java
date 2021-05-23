package structure.adapterMode.classAdapter;

/**
 * @author timothy
 * @data 2021年05月21日 4:43 下午
 * 类适配器
 */
public class ClassAdapter extends OtherClass implements Target {

    /**
     * 调用 OtherClass 的方法
     */
    @Override
    public void request() {
        specificRequest();
    }
}
