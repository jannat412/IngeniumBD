package com.ingeniumbd.ingeniumbd.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.ingeniumbd.ingeniumbd.ChildInfo;
import com.ingeniumbd.ingeniumbd.CustomAdapter;
import com.ingeniumbd.ingeniumbd.GroupInfo;
import com.ingeniumbd.ingeniumbd.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class ItTreaning extends Fragment {

    public List<Integer> groupImages;
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_it_treaning,
                container, false);
        loadData();
        simpleExpandableListView = (ExpandableListView) view.findViewById(R.id.simpleExpandableListView);
        listAdapter = new CustomAdapter(getActivity(), deptList);
        simpleExpandableListView.setAdapter(listAdapter);


        expandAll();
        collapseAll();
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                GroupInfo headerInfo = deptList.get(groupPosition);
                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                return false;
            }
        });

        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                GroupInfo headerInfo = deptList.get(groupPosition);
                return false;
            }
        });


        return view;
    }
    public void loadData(){
        addProduct("Android Apps Development","\nIf you are searching a way to reach out every possible customer in your domain, you should unquestionably think about mobile platforms and mobile application development.\n" +
                "Android Application lets you go beyond boundaries.");
        addProduct("Professional Website Design","\nA web designer can become self-employed, or if he or she prefers, it is possible to work for a web design firm. When working for a firm, employers tend to prefer a person to have a course or training from any institute.");
        addProduct("Graphic Design","\nLet's start designing with your exclusive idea.....!\n" +
                "Its fun, easy and profitable working online as a Graphic Designer. Thousands of Client's are looking for Graphic Designer Everyday!\n" +
                "You can be the Next successful EARNER!");
        addProduct("Motion Graphics & Video Editing","\nMotion graphics & video editing is a wide field that includes drawing and development, management in 2D and 3D graphic design, creative and business careers and education.");
        addProduct("SEO course","\nSEO Career is a professional development and internship program.We provide the Education, Development, Growth and Experience needed to gain a competitive advantage and launch your career.");
    };


    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }


    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }
    private int addProduct(String department, String product){

        int groupPosition = 0;

        GroupInfo headerInfo = subjects.get(department);
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        int listSize = productList.size();
        listSize ++;

        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }

}
