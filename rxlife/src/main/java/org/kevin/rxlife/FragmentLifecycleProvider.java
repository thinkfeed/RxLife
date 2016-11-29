package org.kevin.rxlife;

import org.kevin.rxlife.event.FragmentEvent;

/**
 * Created by think on 2016/11/29.
 */

public class FragmentLifecycleProvider extends LifecycleProvider<FragmentEvent> {
    @Override
    public void nextEvent(FragmentEvent t) {
        subject.onNext(t);
    }
}
