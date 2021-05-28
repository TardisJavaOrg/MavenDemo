package action.observer;

/**
 * @author timothy
 * @data 2021年05月24日 4:32 下午
 * 具体目标
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        for (Observer ob : arr) {
            ob.response();
        }
    }
}
