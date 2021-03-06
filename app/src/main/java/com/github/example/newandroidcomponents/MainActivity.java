package com.github.example.newandroidcomponents;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.example.newandroidcomponents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    HelloViewModel helloViewModel;
    TimerInteractor interactor;
    private Example1Fragment example1Fragment;
    private Example2Fragment example2Fragment;
    private TimeViewModel timeViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        helloViewModel = ViewModelProviders.of(this).get(HelloViewModel.class);
        timeViewModel = ViewModelProviders.of(this).get(TimeViewModel.class);
        subscribe();
        int number = timeViewModel.getNumber().getValue() == null ? 0 : Integer.parseInt(timeViewModel.getNumber().getValue());
        interactor = new TimerInteractor(this, number++, new TimerInteractor.TimerInteractorListener() {
            @Override
            public void onUpdate(Integer time) {
                timeViewModel.setNumber(time);
            }

            @Override
            public void onComplete() {
                showToast("Complete");
            }
        });
        if (savedInstanceState == null ) {
            example1Fragment = new Example1Fragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentFragment, example1Fragment)
                    .commit();

            example2Fragment = new Example2Fragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentFragment, example2Fragment)
                    .commit();
        }
    }

    private void subscribe() {
        Observer<String> textChanged = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                showToast(message);
            }
        };
        helloViewModel.getMessage()
                .observe(this, textChanged);
    }

    public void saySomething(View view) {
        switch (view.getId()) {
            case R.id.button:
                helloViewModel.sayHello(binding.editText.getText().toString());
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
