package org.kevin.rxlife;

import org.kevin.rxlife.event.ActivityEvent;

/**
 * Created by think on 2016/11/29.
 */

public class ActivityLifecycleProvider extends LifecycleProvider<ActivityEvent> {
    @Override
    public void nextEvent(ActivityEvent t) {
        subject.onNext(t);
    }
}
