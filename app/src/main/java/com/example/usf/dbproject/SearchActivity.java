package com.example.usf.dbproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.example.usf.dbproject.RecyclerView.RecyclerViewAdapter;
import com.example.usf.dbproject.SearchFragments.SearchMovieFragment;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<Object> movies, series, users;
    public String newTxt;
    private RecyclerView rv;
    private RecyclerViewAdapter rvadapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activitySearch_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.activitySearch_searchview);
        searchView.setIconifiedByDefault(false);

//        searchView.setOnQueryTextListener(this);

        viewPager = (ViewPager) findViewById(R.id.activitySearch_viewpager);
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SearchMovieFragment(), "Movie");
        adapter.addFrag(new SearchMovieFragment(), "Series");
        adapter.addFrag(new SearchMovieFragment(), "Users");
        viewPager.setAdapter(adapter);

    }

}
