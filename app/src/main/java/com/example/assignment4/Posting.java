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
import android.widget.TextView;

public class Posting extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_posting, container, false);
        MainActivity activity = (MainActivity) getActivity();
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragmentsreturn inflater.inflate(R.layout.fragment_home, container, false);
        Textbook book = activity.getTextbooks()[activity.getViewPosting()];
        TextView author = (TextView) view.findViewById(R.id.author);
        TextView price = (TextView)view.findViewById(R.id.price1);
        TextView title = (TextView)view.findViewById(R.id.title1);
        TextView seller = (TextView)view.findViewById(R.id.seller1);
        TextView class_tag = (TextView)view.findViewById(R.id.class_tag);
        TextView isbn = (TextView)view.findViewById(R.id.isbn);
        TextView quality = (TextView)view.findViewById(R.id.quality2);
        TextView last_used = (TextView)view.findViewById(R.id.last_used);
        author.setText(book.getAuthor());
        title.setText(book.getTitle());
        price.setText("$"+ String.valueOf(book.getPrice()));
        seller.setText("Sold by " + book.getSeller());
        class_tag.setText("Class: " + book.getClassTag());
        isbn.setText("ISBN: " + book.getISBN());
        quality.setText("Quality: " + book.getQuality());
        last_used.setText("Last Used: " + book.getLastUsed());
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Posting");
    }



}
