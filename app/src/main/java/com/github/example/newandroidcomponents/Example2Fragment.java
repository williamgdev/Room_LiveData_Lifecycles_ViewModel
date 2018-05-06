package com.github.example.newandroidcomponents;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Example2Fragment extends Fragment {


    private TimeViewModel timeViewModel;

    public Example2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example1, container, false);
        timeViewModel = ViewModelProviders.of(getActivity()).get(TimeViewModel.class);
        subscribeTimeChanges();
        return view;
    }

    private void subscribeTimeChanges() {
        timeViewModel.getNumber().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                View view = getView().findViewById(R.id.fragmentTextView);
                ((TextView) view).setText(s.toString());
            }
        });
    }

}
