package com.design.pattern.action.observer.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangling on 2017/11/10 0010
 */
public abstract class PullSubject {

    private List<PullObserver> list = new ArrayList<>();

    public void attach(PullObserver pullObserver){
        list.add(pullObserver);
    }
    public void detach(PullObserver pullObserver){
        list.remove(pullObserver);
    }
    public void notifyPullObservers(){
        list.stream().forEach(pullObserver -> pullObserver.update(this));
    }
}
