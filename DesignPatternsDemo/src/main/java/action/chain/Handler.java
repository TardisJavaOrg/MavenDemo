package action.chain;

/**
 * @author timothy
 * @data 2021年05月24日 5:02 下午
 * 责任链模式
 */
public abstract class Handler {
    private Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return next;
    }

    public abstract void handlerRequest(String handlerString);

}
