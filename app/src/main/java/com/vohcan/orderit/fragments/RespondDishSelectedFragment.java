package com.vohcan.orderit.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.vohcan.orderit.R;
import com.vohcan.orderit.model.Dish;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RespondDishSelectedFragment extends Fragment {


    public RespondDishSelectedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_respond_dish_selected, container, false);

        RecyclerView select = (RecyclerView) root.findViewById(R.id.dish_selected);
        return root;
    }

}


