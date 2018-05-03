package com.github.example.newandroidcomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

class HelloViewModel extends ViewModel{

    private MutableLiveData<String> message = new MutableLiveData<>();

    public void sayHello(final String message) {
        this.message.postValue("Hello " + message);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                sayTryAgain();
            }
        }, 4000);
    }

    private void sayTryAgain() {
        this.message.postValue("Do you want to try again");
    }

    public LiveData<String> getMessage() {
        return message;
    }
}
