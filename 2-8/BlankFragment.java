package com.example.datapass;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String ans=this.getArguments().getString("msg");

        Toast.makeText(getActivity(), ""+ans, Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}