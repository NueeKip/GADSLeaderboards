package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.leaderboard.fragments.FragmentIq;
import com.example.leaderboard.fragments.FragmentLearner;
import com.example.leaderboard.iq.IqAdapter;
import com.example.leaderboard.submit.Submit;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    private Button button;



    /****** Create Thread that will sleep for 5 seconds****/

    // start thread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubmit();
            }
        });


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragments
        adapter.AddFragment(new FragmentLearner(),"Learner leaders");
        adapter.AddFragment(new FragmentIq(),"Skill IQ leaders");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void openSubmit(){
        Intent intent = new Intent(this, Submit.class);
        startActivity(intent);

    } 
}