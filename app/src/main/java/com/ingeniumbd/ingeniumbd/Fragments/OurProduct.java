package com.ingeniumbd.ingeniumbd.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ingeniumbd.ingeniumbd.ProductAdaptur;
import com.ingeniumbd.ingeniumbd.R;


public class OurProduct extends Fragment {

    ListView simpleList;
    String countryList[] = {"Resturent Management Ststem", "Hospital Management System", "Education Management System","Point Of Salse", "ERP"};
    int flags[] = {R.drawable.res,R.drawable.hos,R.drawable.edu,R.drawable.pos,R.drawable.erp};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_our_product,
                container, false);
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        ProductAdaptur customAdapter = new ProductAdaptur(getActivity().getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
        return view;

    }

}
