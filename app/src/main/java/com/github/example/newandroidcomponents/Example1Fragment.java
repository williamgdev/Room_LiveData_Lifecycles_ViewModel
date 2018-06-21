package com.github.example.newandroidcomponents;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.example.newandroidcomponents.databinding.FragmentExample1Binding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Example1Fragment extends Fragment {


    private TimeViewModel timeViewModel;
    private FragmentExample1Binding binding;

    public Example1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_example1, container, false);
        timeViewModel = ViewModelProviders.of(getActivity()).get(TimeViewModel.class);
        subscribeTimeChanges();
        return binding.getRoot();
    }

    private void subscribeTimeChanges() {
        timeViewModel.getNumber().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                binding.fragmentTextView.setText(s.toString());
            }
        });
    }

}
