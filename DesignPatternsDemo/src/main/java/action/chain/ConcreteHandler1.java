package action.chain;

/**
 * @author timothy
 * @data 2021年05月24日 5:02 下午
 */
public class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest(String handlerString) {
        if ("one".equals(handlerString)) {
            System.out.println("one");
            return;
        }
        if (getNext() != null) {
            getNext().handlerRequest(handlerString);
        } else {
            System.out.println("no handler");
        }
    }
}
