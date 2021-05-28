package action.chain;

/**
 * @author timothy
 * @data 2021年05月24日 5:08 下午
 * 责任链模式
 *
 */
public class Main {
    public static void main(String[] args) {
         Handler handler1= new ConcreteHandler1();
         Handler handler2= new ConcreteHandler2();
         handler1.setNext(handler2);
         handler1.handlerRequest("one");
    }
}
