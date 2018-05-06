package com.github.example.newandroidcomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

class TimeViewModel extends ViewModel{
    private MutableLiveData<String> text = new MutableLiveData<>();

    public void setText(String text) {
        this.text.postValue(text);
    }

    public LiveData<String> getText() {
        return text;
    }
}
