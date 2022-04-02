package com.example.assignment4;

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
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Home.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener,
        Search.OnFragmentInteractionListener2, Search.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //               .setAction("Action", null).show();
        //    }
        //});

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textbooks[0] = new Textbook(29.50,"Introduction to Algorithms","Loren Terveen","Tyler Deng","Used","582349","3","CSCI 4041","Last used Fall 2018 with Carl Sturtivant");
        textbooks[1] = new Textbook(29.50,"Calculus 3","Math author","Tyler Deng","Used","2309123","3","MATH 2243", "Last used Fall 2018 with Carl Sturtivant");

        setUpHomeFragment();
    }

    private void setUpHomeFragment(){

        Fragment fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void goToChat (View view){
        Fragment fragment = new Chat();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }

    public void goToHome(View view) {
        textbooks[0] = new Textbook(29.50,"Introduction to Algorithms","Loren Terveen","Tyler Deng","Used","582349","3","CSCI 4041","Last used Fall 2018 with Carl Sturtivant");
        Fragment fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void goToReserveConfirmation(View view) {
        Fragment fragment = new ReserveConfirmation();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }

    public void goToSellerProfile(View view) {
        Fragment fragment = new SellerProfile();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void goToPurchaseConfirmation(View view) {
        for (int i = viewPosting;i<postPageNum-1;i++) {
            textbooks[i]=textbooks[i+1];
        }
        textbooks[postPageNum-1] = null;
        postPageNum-=1;
        Fragment fragment = new PurchaseConfirmation();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void goToReportListing(View view) {
        Fragment fragment = new ReportListing();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }

    public void goToWishList(MenuItem menuItem) {
        Fragment fragment = new Wishlist();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void goToProfile(MenuItem menuItem) {
        Fragment fragment = new Profile();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }

    public void goToScheduleMeeting(View view) {
        Fragment fragment = new ScheduleMeeting();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void goToChooseLocation(View view) {
        Fragment fragment = new ChooseLocation();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();
    }
    public void createPost(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        EditText bookName = (EditText) findViewById(R.id.NameText);
        EditText authorName = (EditText) findViewById(R.id.authorText);
        EditText edition = (EditText) findViewById(R.id.editionText);
        EditText isbnNum = (EditText) findViewById(R.id.isbnText);
        EditText quality = (EditText) findViewById(R.id.Qual);
        EditText tags = (EditText) findViewById(R.id.classTagText);
        EditText lastUsedClass = (EditText) findViewById(R.id.editText2);
        EditText lastUsedProf = (EditText) findViewById(R.id.editText10);



        String tag = tags.getText().toString();
        String name = bookName.getText().toString();
        String author = authorName.getText().toString();
        String ed = edition.getText().toString();
        String isbn = isbnNum.getText().toString();
        String itemQual = quality.getText().toString();
        String lastUsed = (lastUsedClass.getText().toString() + ", " + lastUsedProf.getText().toString());

        Textbook newbook = new Textbook(0, name, author,"Tom Riddle", itemQual,isbn,ed,tag,lastUsed);
        textbooks[postPageNum] = newbook;
        postPageNum++;
        Fragment fragment = new Pricing();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }

    public void finalizePost(View view) {
//
        EditText price = (EditText) findViewById(R.id.pricingText);

        double p = Double.valueOf(price.getText().toString());
        textbooks[postPageNum-1].setPrice(p);

        Fragment fragment = new AfterPost();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

//        return true;
    }

    public void goToNotificationsSettings(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Fragment fragment = new NotificationsSettings();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }

    public void goToAbout(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Fragment fragment = new About();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }
    public void goToSearch(View view){

        Fragment fragment = new Search();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();


//        return true;
    }
    public void goToPost(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Fragment fragment = new Post();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }
    public void goToPosting(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Fragment fragment = new Posting();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

//        return true;
    }

    public void goToSearchClass(View view) {

        Fragment fragment = new SearchClass();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

    }

    public void goToRateTransactions(View view) {

        Fragment fragment = new RateTransaction();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

    }

    public void goToConfirmTransactions(View view) {

        Fragment fragment = new ConfirmTransactions();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

    }

    public void goToReportTransactions(View view) {

        Fragment fragment = new ReportTransaction();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

    }

    public void sendWishMessage(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Toast.makeText(this, "Successfully added to wishlist!", Toast.LENGTH_SHORT).show();

//        return true;
    }
    public void sendReview(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Toast.makeText(this, "Review Added!", Toast.LENGTH_SHORT).show();
        Fragment fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }
    public void sendReport(View view){
//        Intent intent = new Intent(this, Pricing.class);
//        startActivity(intent);

        Toast.makeText(this, "Item has been reported!", Toast.LENGTH_SHORT).show();
        Fragment fragment = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null).commit();

//        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.messages) {
            fragment = new Message();
        } else if (id == R.id.home) {
            fragment = new Home();

        } else if (id == R.id.profile) {
            fragment = new Profile();

        }
        else if (id == R.id.my_history) {
            fragment = new MyHistory();
        } else if (id == R.id.post) {
            fragment = new Post();
        }  else if (id == R.id.settings) {
            fragment = new Settings();
        } else if (id == R.id.notification){
            fragment = new Notification();
        }
        if (fragment !=null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(String userContent) {
        searchTerm = userContent;
        Fragment fragment = new Search();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }
    @Override
    public void onFragmentInteraction2(int userContent) {
        viewPosting = userContent;
        Fragment fragment = new Posting();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }
    public int getViewPosting() {
        return viewPosting;
    }
    public Textbook[] getTextbooks() {
        return textbooks;
    }

    public String getSearchTerm() {
        return searchTerm;
    }
    public void setSearchTerm(String s) {
        searchTerm = s;
    }
    public int getPostPageNum() {return postPageNum;}
    private int postPageNum = 2;
    private Textbook[] textbooks = new Textbook[50];
    private String searchTerm ="";
    private int viewPosting = 0;

}