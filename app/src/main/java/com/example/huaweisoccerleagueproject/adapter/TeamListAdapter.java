package com.example.huaweisoccerleagueproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huaweisoccerleagueproject.R;
import com.example.huaweisoccerleagueproject.model.TeamList;

import java.util.ArrayList;
import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamListHolder> {
    private List<TeamList> teamLists = new ArrayList<>();

    @NonNull
    @Override
    public TeamListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_list_item, viewGroup, false);

        return new TeamListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamListHolder teamListHolder, int position) {

        TeamList currTeamList = teamLists.get(position);
        teamListHolder.team1.setText(currTeamList.getTeam1());
        teamListHolder.team2.setText(currTeamList.getTeam2());
        teamListHolder.team3.setText(currTeamList.getTeam3());
        teamListHolder.team4.setText(currTeamList.getTeam4());
        teamListHolder.team5.setText(currTeamList.getTeam5());
        teamListHolder.team6.setText(currTeamList.getTeam6());
        teamListHolder.team7.setText(currTeamList.getTeam7());
        teamListHolder.team8.setText(currTeamList.getTeam8());
        teamListHolder.team9.setText(currTeamList.getTeam9());
        teamListHolder.team10.setText(currTeamList.getTeam10());
        teamListHolder.team11.setText(currTeamList.getTeam11());
        teamListHolder.team12.setText(currTeamList.getTeam12());
        teamListHolder.team13.setText(currTeamList.getTeam13());
        teamListHolder.team14.setText(currTeamList.getTeam14());
        teamListHolder.team15.setText(currTeamList.getTeam15());
        teamListHolder.team16.setText(currTeamList.getTeam16());
        teamListHolder.team17.setText(currTeamList.getTeam17());
        teamListHolder.team18.setText(currTeamList.getTeam18());
    }

    @Override
    public int getItemCount() {
        return teamLists.size();
    }

    public void setTeamLists(List<TeamList> teamLists) {
        this.teamLists = teamLists;
        notifyDataSetChanged();
    }

    class TeamListHolder extends RecyclerView.ViewHolder {
        private TextView team1;
        private TextView team2;
        private TextView team3;
        private TextView team4;
        private TextView team5;
        private TextView team6;
        private TextView team7;
        private TextView team8;
        private TextView team9;
        private TextView team10;
        private TextView team11;
        private TextView team12;
        private TextView team13;
        private TextView team14;
        private TextView team15;
        private TextView team16;
        private TextView team17;
        private TextView team18;


        public TeamListHolder(@NonNull View itemView) {
            super(itemView);
            team1 = itemView.findViewById(R.id.team_list_team1);
            team2 = itemView.findViewById(R.id.team_list_team2);
            team3 = itemView.findViewById(R.id.team_list_team3);
            team4 = itemView.findViewById(R.id.team_list_team4);
            team5 = itemView.findViewById(R.id.team_list_team5);
            team6 = itemView.findViewById(R.id.team_list_team6);
            team7 = itemView.findViewById(R.id.team_list_team7);
            team8 = itemView.findViewById(R.id.team_list_team8);
            team9 = itemView.findViewById(R.id.team_list_team9);
            team10 = itemView.findViewById(R.id.team_list_team10);
            team11 = itemView.findViewById(R.id.team_list_team11);
            team12 = itemView.findViewById(R.id.team_list_team12);
            team13 = itemView.findViewById(R.id.team_list_team13);
            team14 = itemView.findViewById(R.id.team_list_team14);
            team15 = itemView.findViewById(R.id.team_list_team15);
            team16 = itemView.findViewById(R.id.team_list_team16);
            team17 = itemView.findViewById(R.id.team_list_team17);
            team18 = itemView.findViewById(R.id.team_list_team18);
        }
    }
}
