package com.example.myapplication.ui.Mobiles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.myapplication.Model;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MobileFragment extends Fragment
{
    SliderLayout sliderLayout;
    HashMap<String,Integer>hashMap=new HashMap<>();
    GridView gridView;
    List<Model>list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_mobile, container, false);

        sliderLayout=view.findViewById(R.id.slider);
        gridView=view.findViewById(R.id.grid);

            hashMap.put("A1",R.drawable.p1);
            hashMap.put("A2",R.drawable.p2);
            hashMap.put("A3",R.drawable.p3);
            list=new ArrayList<>();
            for(String name:hashMap.keySet())
            {
                TextSliderView textSliderView=new TextSliderView(getActivity());
                textSliderView.description(name)
                        .image(hashMap.get(name));

                sliderLayout.addSlider(textSliderView);
                sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage);

            }

            list.add(new Model("SAMSUNG",R.drawable.p1));
            list.add(new Model("LENOVO",R.drawable.p2));
            list.add(new Model("MOTOROLA",R.drawable.p1));
            list.add(new Model("XYZ",R.drawable.p2));

            MyAdapter myAdapter = new MyAdapter(getActivity(),list);
            gridView.setAdapter(myAdapter);


        return view;

    }
}