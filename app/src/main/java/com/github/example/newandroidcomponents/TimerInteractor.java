package com.github.example.newandroidcomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import java.util.Timer;
import java.util.TimerTask;

class TimerInteractor implements LifecycleObserver{

    private final Timer timer;
    private TimerInteractorListener listener;
    private int count;

    public TimerInteractor(LifecycleOwner lifecycleOwner, final TimerInteractorListener listener) {
        this.listener = listener;

        timer = new Timer();

        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                listener.onUpdate(String.valueOf(count++));
            }
        }, 1000, 4000);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stop() {
        timer.cancel();
        listener.onComplete();
    }

    public interface TimerInteractorListener {
        void onUpdate(String time);
        void onComplete();
    }
}
