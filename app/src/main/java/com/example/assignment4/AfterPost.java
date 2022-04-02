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
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import android.widget.EditText;

public class AfterPost extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view =  inflater.inflate(R.layout.fragment_after_post, container, false);
        MainActivity activity = (MainActivity) getActivity();
        Textbook book = activity.getTextbooks()[1];
        TextView name = (TextView) view.findViewById(R.id.itemName);
        TextView cost = (TextView) view.findViewById(R.id.finalPrice);
        name.setText(book.getTitle());
        cost.setText("Price: $" + String.format("%.2f",book.getPrice()));

        //return inflater.inflate(R.layout.fragment_after_post, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("");
    }

}
