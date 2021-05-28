package action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author timothy
 * @data 2021年05月24日 4:32 下午
 * 主题
 */
public abstract class Subject {

    protected List<Observer> arr = new ArrayList<>();

    public void add(Observer observer){
        arr.add(observer);
    }

    public void remove(Observer observer){
        arr.remove(observer);
    }

    public abstract void notifyObserver();
}
