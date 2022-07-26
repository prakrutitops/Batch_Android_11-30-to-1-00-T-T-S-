package com.example.fragmentex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentex.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {

    FragmentBlankBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

            binding.t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    BlankFragment2 b2 =new BlankFragment2();
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.frmid,b2).commit();

                }
            });



        return view;
    }
}