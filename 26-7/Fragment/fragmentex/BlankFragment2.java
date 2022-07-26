package com.example.fragmentex;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentex.databinding.FragmentBlank2Binding;
import com.example.fragmentex.databinding.FragmentBlankBinding;


public class BlankFragment2 extends Fragment {

   FragmentBlank2Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentBlank2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

            binding.t2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                    Intent i =new Intent(getActivity(),MainActivity.class);
                    startActivity(i);


                }
            });

        return view;
    }
}