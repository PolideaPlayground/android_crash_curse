package com.wpam.sob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.wpam.sob.room.AppDatabase;
import com.wpam.sob.view.FavouritesFragment;
import com.wpam.sob.view.SearchFragment;


public class MainActivity extends AppCompatActivity {

    public static AppDatabase appDatabase;

    DemoCollectionAdapter demoCollectionAdapter;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "wpam-db")
                .allowMainThreadQueries()
                .build();


        demoCollectionAdapter = new DemoCollectionAdapter(this);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(demoCollectionAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->  { if (position == 0) { tab.setText("Search "); } else { tab.setText("Favourites"); } }
        ).attach();
    }
}

class DemoCollectionAdapter extends FragmentStateAdapter {
    public DemoCollectionAdapter(FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new SearchFragment();
        } else {
            return new FavouritesFragment();
        }
    }



    @Override
    public int getItemCount() {
        return 2;
    }
}
