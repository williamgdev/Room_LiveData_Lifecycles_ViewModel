package com.github.example.newandroidcomponents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Example1Fragment extends Fragment {


    public Example1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example1, container, false);
        return view;
    }

    public void setText(String text) {
        ((TextView)getView().findViewById(R.id.fragmentTextView)).setText(text);
    }

}
