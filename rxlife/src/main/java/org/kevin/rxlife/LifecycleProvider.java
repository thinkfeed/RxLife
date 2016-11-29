package org.kevin.rxlife;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Created by think on 2016/11/29.
 */

public abstract class LifecycleProvider<E> {

    public PublishSubject<E> subject = PublishSubject.create();

    public abstract void nextEvent(E t);

    @NonNull
    @CheckResult
    public final <O> Observable<O> lifecycle() {
        return (Observable<O>) subject.asObservable();
    }
    @NonNull
    public <O> Observable.Transformer<O, O> bindUntilEvent(@NonNull final E event) {
        return new Observable.Transformer<O, O>() {
            @Override
            public Observable<O> call(Observable<O> sourceObservable) {
                Observable<E> compareLifecycleObservable =
                        subject.takeFirst(new Func1<E, Boolean>() {
                            @Override
                            public Boolean call(E cycleEvent) {
                                return cycleEvent.equals(event);
                            }
                        });
                return sourceObservable.takeUntil(compareLifecycleObservable);
            }
        };
    }
}
