package com.example.assignment4;

/**
 * Created by karanjaswani on 2/7/18.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
public class Home extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        MainActivity activity = (MainActivity) getActivity();
        Textbook book1 = activity.getTextbooks()[0];
        TextView price1 = (TextView)view.findViewById(R.id.price1);
        TextView title1 = (TextView)view.findViewById(R.id.title1);
        TextView seller1 = (TextView)view.findViewById(R.id.seller1);
        final EditText searchBox = (EditText) view.findViewById(R.id.search);
        searchBox.setText(activity.getSearchTerm());
        search_term = searchBox.getEditableText().toString();
        title1.setText(book1.getTitle());
        price1.setText("$"+ String.valueOf(book1.getPrice()));
        seller1.setText("Sold by " + book1.getSeller());
        Button search = (Button)view.findViewById(R.id.button2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(searchBox.getText().toString());
            }
        });
       // return inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    private String search_term;
    public void onButtonPressed(String search) {
        if (mListener != null) {
            mListener.onFragmentInteraction(search);
        }
    }
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String userContent);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private OnFragmentInteractionListener mListener;
}
