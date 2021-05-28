package action.observer;

/**
 * @author timothy
 * @data 2021年05月24日 4:36 下午
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("concrete_observer_1 response");
    }
}
