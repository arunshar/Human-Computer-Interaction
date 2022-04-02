package com.example.assignment4;

/**
 * Created by karanjaswani on 2/7/18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScheduleMeeting extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_schedule_meeting, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Schedule Meeting");
        Spinner dropdown = view.findViewById(R.id.spinner);
        Spinner dropdown2 = view.findViewById(R.id.spinner2);
        Spinner dropdown3 = view.findViewById(R.id.spinner3);
//create a list of items for the spinner.
        String[] items = new String[]{"Monday 10/23", "Tuesday 10/24", "Wednesday 10/25", "Thursday 10/26", "Friday 10/27", "Saturday 10/28", "Sunday 10/29"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter);
        dropdown3.setAdapter(adapter);

    }
}
