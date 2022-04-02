package com.example.assignment4;

/**
 * Created by karanjaswani on 2/7/18.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Search extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        MainActivity activity = (MainActivity) getActivity();
        Textbook[] textbooks = activity.getTextbooks();
        final EditText searchBox = (EditText) view.findViewById(R.id.search);
        searchBox.setText(activity.getSearchTerm());
        search_term = searchBox.getEditableText().toString();
        int index = 0;
        TextView price1 = (TextView)view.findViewById(R.id.price01);
        TextView title1 = (TextView)view.findViewById(R.id.title01);
        TextView seller1 = (TextView)view.findViewById(R.id.seller01);
        TextView quality1 = (TextView)view.findViewById(R.id.quality01);
        ImageView image1 = (ImageView) view.findViewById(R.id.imageView01);
        TextView days1 = (TextView) view.findViewById(R.id.days1);
        TextView rating1 = (TextView) view.findViewById(R.id.rating01);
        ImageView image2 = (ImageView) view.findViewById(R.id.imageView02);
        TextView price2 = (TextView)view.findViewById(R.id.price02);
        TextView title2 = (TextView)view.findViewById(R.id.title02);
        TextView seller2 = (TextView)view.findViewById(R.id.seller02);
        TextView quality2 = (TextView)view.findViewById(R.id.quality02);
        TextView days2 = (TextView) view.findViewById(R.id.days02);
        TextView rating2 = (TextView) view.findViewById(R.id.rating02);
        ImageView image3 = (ImageView) view.findViewById(R.id.imageView03);
        TextView price3 = (TextView)view.findViewById(R.id.price03);
        TextView title3 = (TextView)view.findViewById(R.id.title03);
        TextView seller3 = (TextView)view.findViewById(R.id.seller03);
        TextView quality3 = (TextView)view.findViewById(R.id.quality03);
        TextView days3 = (TextView) view.findViewById(R.id.days03);
        TextView rating3 = (TextView) view.findViewById(R.id.rating03);
        CardView posting1_button = (CardView) view.findViewById(R.id.posting_1);
        CardView posting2_button = (CardView) view.findViewById(R.id.posting_2);
        CardView posting3_button = (CardView) view.findViewById(R.id.posting_3);
        for (int i = 0;i<activity.getPostPageNum();i++) {
            if (textbooks[i].getTitle().equals(search_term) || textbooks[i].getClassTag().equals(search_term) ||
                    textbooks[i].getSeller().equals(search_term) || textbooks[i].getQuality().equals(search_term) ||
                    textbooks[i].getISBN().equals(search_term)) {
                //sorry.setVisibility(View.INVISIBLE);
                if (index == 0) {
                    price1.setText("$" + String.valueOf(textbooks[i].getPrice()));
                    title1.setText(textbooks[i].getTitle());
                    seller1.setText("Sold by " + textbooks[i].getSeller());
                    quality1.setText(textbooks[i].getQuality());
                    image1.setVisibility(View.VISIBLE);
                    days1.setVisibility(View.VISIBLE);
                    rating1.setVisibility(View.VISIBLE);
                    first_book_index = i;
                    index++;

                }
                else if (index == 1) {
                    price2.setText("$" + String.valueOf(textbooks[i].getPrice()));
                    title2.setText(textbooks[i].getTitle());
                    seller2.setText("Sold by " + textbooks[i].getSeller());
                    quality2.setText(textbooks[i].getQuality());
                    image2.setVisibility(View.VISIBLE);
                    days2.setVisibility(View.VISIBLE);
                    rating2.setVisibility(View.VISIBLE);
                    second_book_index = i;
                    index++;

                }
                else if (index == 2) {
                    price3.setText("$" + String.valueOf(textbooks[i].getPrice()));
                    title3.setText(textbooks[i].getTitle());
                    seller3.setText("Sold by " + textbooks[i].getSeller());
                    quality3.setText(textbooks[i].getQuality());
                    image3.setVisibility(View.VISIBLE);
                    days3.setVisibility(View.VISIBLE);
                    rating3.setVisibility(View.VISIBLE);
                    third_book_index = i;
                    index++;

                }
            }
        }
        Button search = (Button)view.findViewById(R.id.button2);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(searchBox.getText().toString());
            }
        });
        posting1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed2(first_book_index);
            }
        });
        posting2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed2(second_book_index);
            }
        });
        // return inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Search");

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            mListener2 = (OnFragmentInteractionListener2) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mListener2 = null;
    }
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String userContent);
    }
    public interface OnFragmentInteractionListener2 {
        public void onFragmentInteraction2(int userContent);
    }
    public void onButtonPressed(String search) {
        if (mListener != null) {
            mListener.onFragmentInteraction(search);
        }
    }
    public void onButtonPressed2(int postingView) {
        if (mListener != null) {
            mListener2.onFragmentInteraction2(postingView);
        }
    }

    private String search_term;
    private int first_book_index;
    private int second_book_index;
    private int third_book_index;

    private OnFragmentInteractionListener mListener;
    private OnFragmentInteractionListener2 mListener2;

}