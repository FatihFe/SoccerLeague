package com.example.huaweisoccerleagueproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.huaweisoccerleagueproject.adapter.TeamListAdapter;
import com.example.huaweisoccerleagueproject.model.TeamList;
import com.example.huaweisoccerleagueproject.viewmodel.TeamListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private TeamListViewModel teamListViewModel;
    private Button drawFixtureButton;
    private RecyclerView teamsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        onCheckedDarkMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        init();
        setDarkMode();
        setTeamListAdapter();
        setNavigationAnimation();
    }

    private void init(){
        drawFixtureButton = (Button) findViewById(R.id.act_main_btn);
        teamsRecyclerView = findViewById(R.id.activity_recycler_view);
    }

    private void onCheckedDarkMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_HuaweiSoccerLeagueProject_DarkTheme);
        }else {
            setTheme(R.style.Theme_HuaweiSoccerLeagueProject);
        }
    }

    public void setDarkMode() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.custom_actionbar);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        Switch darkModeSwitch = (Switch)findViewById(R.id.dark_mode_switch_btn);
        darkModeSwitch.setOnCheckedChangeListener(this);
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.act_main_relative_layout);
                    Animation animation = new AlphaAnimation(0.0f, 3.0f);
                    animation.setDuration(1000);
                    relativeLayout.startAnimation(animation);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    public void setNavigationAnimation() {
        drawFixtureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixtureFragment fragment = new FixtureFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                transaction.addToBackStack(null);
                transaction.add(R.id.fragment_container, fragment, "FIXTURE").commit();
            }
        });
    }

    public void setTeamListAdapter() {
        teamsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamsRecyclerView.setHasFixedSize(true);
        TeamListAdapter adapter = new TeamListAdapter();
        teamsRecyclerView.setAdapter(adapter);
        teamListViewModel = ViewModelProviders.of(this).get(TeamListViewModel.class);
        teamListViewModel.getAllContacts().observe(this, new Observer<List<TeamList>>() {
            @Override
            public void onChanged(List<TeamList> teamLists) {
                adapter.setTeamLists(teamLists);
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Toast.makeText(MainActivity.this, String.valueOf(b), Toast.LENGTH_SHORT).show();
    }
}