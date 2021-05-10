package com.example.huaweisoccerleagueproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huaweisoccerleagueproject.R;
import com.example.huaweisoccerleagueproject.model.Fixture;

import java.util.ArrayList;
import java.util.List;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureAdapter.FixtureHolder> {
    private List<Fixture> fixtures = new ArrayList<>();

    @NonNull
    @Override
    public FixtureHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fixture_list_item, viewGroup, false);

        return new FixtureHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureHolder fixtureHolder, int position) {

        Fixture currFixture = fixtures.get(position);
        fixtureHolder.week.setText(currFixture.getWeek());
        fixtureHolder.match1.setText(currFixture.getMatch1());
        fixtureHolder.match2.setText(currFixture.getMatch2());
        fixtureHolder.match3.setText(currFixture.getMatch3());
        fixtureHolder.match4.setText(currFixture.getMatch4());
        fixtureHolder.match5.setText(currFixture.getMatch5());
        fixtureHolder.match6.setText(currFixture.getMatch6());
        fixtureHolder.match7.setText(currFixture.getMatch7());
        fixtureHolder.match8.setText(currFixture.getMatch8());
        fixtureHolder.match9.setText(currFixture.getMatch9());
    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
        notifyDataSetChanged();
    }

    class FixtureHolder extends RecyclerView.ViewHolder {
        private TextView week;
        private TextView match1;
        private TextView match2;
        private TextView match3;
        private TextView match4;
        private TextView match5;
        private TextView match6;
        private TextView match7;
        private TextView match8;
        private TextView match9;


        public FixtureHolder(@NonNull View itemView) {
            super(itemView);
            week = itemView.findViewById(R.id.list_item_tv_week);
            match1 = itemView.findViewById(R.id.list_item_tv_match1);
            match2 = itemView.findViewById(R.id.list_item_tv_match2);
            match3 = itemView.findViewById(R.id.list_item_tv_match3);
            match4 = itemView.findViewById(R.id.list_item_tv_match4);
            match5 = itemView.findViewById(R.id.list_item_tv_match5);
            match6 = itemView.findViewById(R.id.list_item_tv_match6);
            match7 = itemView.findViewById(R.id.list_item_tv_match7);
            match8 = itemView.findViewById(R.id.list_item_tv_match8);
            match9 = itemView.findViewById(R.id.list_item_tv_match9);
        }
    }
}
