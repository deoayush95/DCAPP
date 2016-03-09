package com.test.ayush.DCAPP;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.ayush.DCAPP.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalRoomType extends android.support.v4.app.Fragment {


    public HospitalRoomType() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.room_types_hospital, container, false);
        return view;
    }


}
