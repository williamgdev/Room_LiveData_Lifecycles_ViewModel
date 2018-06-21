package com.github.example.newandroidcomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class TimeViewModel extends ViewModel{
    public MutableLiveData<Integer> number = new MutableLiveData<>();

    public void setNumber(int number) {
        this.number.postValue(number);
    }

    public LiveData<Integer> getNumber() {
        return number;
    }
}
