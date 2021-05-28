package action.observer;

/**
 * @author timothy
 * @data 2021年05月24日 4:42 下午
 * 观察者模式
 * 在主题中添加 观察者，如果需要 就循环通知所有观察者
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyObserver();
    }
}
