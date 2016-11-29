package org.kevin.rxlifecycle;

import android.os.Bundle;
import android.util.Log;

import org.kevin.rxlife.event.ActivityEvent;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class SampleActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        Log.i("TAG", "Unsubscribing subscription from onPause()");
                    }
                })
                .compose(provider.<Long>bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long num) {
                        Log.i("TAG", "Started in onResume(), running until in onPause(): " + num);
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
