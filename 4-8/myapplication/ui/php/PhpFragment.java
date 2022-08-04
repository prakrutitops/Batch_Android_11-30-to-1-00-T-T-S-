package com.example.myapplication.ui.php;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.myapplication.R;

import java.util.HashMap;


public class PhpFragment extends Fragment {

    SliderLayout sliderLayout;
    HashMap<String,Integer>hashMap=new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_php2, container, false);

        sliderLayout=view.findViewById(R.id.slider);
        hashMap.put("A1",R.drawable.a1);
        hashMap.put("B1",R.drawable.j2);
        hashMap.put("C1",R.drawable.p1);
        hashMap.put("D1",R.drawable.p2);

        for(String name:hashMap.keySet())
        {
            TextSliderView textSliderView=new TextSliderView(getActivity());
            textSliderView.description(name)
                    .image(hashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

                sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage);

            sliderLayout.addSlider(textSliderView);

        }


        return view;
    }
}