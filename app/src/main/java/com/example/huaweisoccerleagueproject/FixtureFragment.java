package com.example.huaweisoccerleagueproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.huaweisoccerleagueproject.adapter.FixtureAdapter;
import com.example.huaweisoccerleagueproject.model.Fixture;
import com.example.huaweisoccerleagueproject.viewmodel.FixtureViewModel;

import java.util.List;

public class FixtureFragment extends Fragment {

    private FixtureViewModel fixtureViewModel;
    private Button backButton;
    private RecyclerView fixtureRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture, container, false);

        init(view);
        setFixtureAdapter(view);
        setBackNavigation(view);

        return view;
    }

    private void init(View view) {
        fixtureRecyclerView = view.findViewById(R.id.fragment_recyclerview);
        backButton = view.findViewById(R.id.fragment_fixture_btn);
    }


    public void setFixtureAdapter(View view) {
        fixtureRecyclerView.setHasFixedSize(true);
        fixtureRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        FixtureAdapter adapter = new FixtureAdapter();
        fixtureRecyclerView.setAdapter(adapter);

        fixtureViewModel = ViewModelProviders.of(this).get(FixtureViewModel.class);
        fixtureViewModel.getAllFixtures().observe(this, new Observer<List<Fixture>>() {
            @Override
            public void onChanged(List<Fixture> fixtures) {
                adapter.setFixtures(fixtures);
            }
        });
    }


    public void setBackNavigation(View view) {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }
}