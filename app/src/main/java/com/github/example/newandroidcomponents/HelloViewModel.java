package com.github.example.newandroidcomponents;

import android.arch.lifecycle.ViewModel;

class HelloViewModel extends ViewModel{
    private String message;

    public void sayHello(String message) {
        this.message = "Hello " + message;
    }

    public String getMessage() {
        return message;
    }
}
