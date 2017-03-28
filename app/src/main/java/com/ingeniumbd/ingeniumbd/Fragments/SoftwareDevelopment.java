package com.ingeniumbd.ingeniumbd.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingeniumbd.ingeniumbd.R;


public class SoftwareDevelopment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_software_development,
                container, false);
        return view;
    }
}
