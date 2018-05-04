package com.github.example.newandroidcomponents;

import java.util.Timer;
import java.util.TimerTask;

class TimerInteractor {

    private final Timer timer;
    private TimerInteractorListener listener;
    private int count;

    public TimerInteractor(final TimerInteractorListener listener) {
        this.listener = listener;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                listener.onUpdate(String.valueOf(count++));
            }
        }, 1000, 4000);
    }

    public interface TimerInteractorListener {
        void onUpdate(String time);
        void onComplete();
    }
}
