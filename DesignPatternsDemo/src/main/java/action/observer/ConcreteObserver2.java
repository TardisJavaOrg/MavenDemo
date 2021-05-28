package action.observer;

/**
 * @author timothy
 * @data 2021年05月24日 4:36 下午
 * 具体观察者
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("concrete_observer_2 response");
    }
}
