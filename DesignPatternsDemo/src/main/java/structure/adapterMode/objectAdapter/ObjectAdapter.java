package structure.adapterMode.objectAdapter;

/**
 * @author timothy
 * @data 2021年05月21日 4:43 下午
 *
 */
public class ObjectAdapter implements Target {

    OtherClass otherClass;

    public ObjectAdapter(OtherClass otherClass) {
        this.otherClass = otherClass;
    }

    /**
     * 调用第三方方法
     */
    @Override
    public void request() {
        otherClass.specificRequest();
    }
}
