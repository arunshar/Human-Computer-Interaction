package com.example.assignment4;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyHistoryCancel extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        final View view =  inflater.inflate(R.layout.fragment_cancel_confirmation, container, false);
//        View view_1 =  inflater.inflate(R.layout.fragment_my_history, container, false);
//        Button button = view.findViewById(R.id.button32);
//        final TextView txt = view_1.findViewById(R.id.textView58);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view_1) {
//                txt.setVisibility(View.GONE);
////                TextView view_1 =
////                        view_1.setVisibility(View.INVISIBLE);
//            }
//        });
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        getActivity().setTitle("My History");
//    }
}
