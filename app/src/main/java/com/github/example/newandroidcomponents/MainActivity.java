package com.github.example.newandroidcomponents;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    HelloViewModel helloViewModel;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloViewModel = ViewModelProviders.of(this).get(HelloViewModel.class);
        editText = findViewById(R.id.editText);
    }

    public void saySomething(View view) {
        switch (view.getId()) {
            case R.id.button:
                if (helloViewModel.getMessage() == null) {
                    helloViewModel.sayHello(editText.getText().toString());
                }
                showToast(helloViewModel.getMessage());
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
