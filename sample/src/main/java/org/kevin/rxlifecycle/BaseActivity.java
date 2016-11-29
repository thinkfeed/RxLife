package org.kevin.rxlifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.kevin.rxlife.ActivityLifecycleProvider;
import org.kevin.rxlife.event.ActivityEvent;

/**
 * Created by think on 2016/11/29.
 */

public class BaseActivity extends AppCompatActivity {
    ActivityLifecycleProvider provider = new ActivityLifecycleProvider();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider.nextEvent(ActivityEvent.CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        provider.nextEvent(ActivityEvent.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        provider.nextEvent(ActivityEvent.RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        provider.nextEvent(ActivityEvent.PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        provider.nextEvent(ActivityEvent.STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        provider.nextEvent(ActivityEvent.DESTROY);
    }
}
