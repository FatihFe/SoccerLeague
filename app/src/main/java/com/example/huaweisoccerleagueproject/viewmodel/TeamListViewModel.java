package com.example.huaweisoccerleagueproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.huaweisoccerleagueproject.model.TeamList;
import com.example.huaweisoccerleagueproject.repository.TeamListRepository;

import java.util.List;

public class TeamListViewModel extends AndroidViewModel {

    private TeamListRepository repository;
    private LiveData<List<TeamList>> allTeamLists;

    public TeamListViewModel(@NonNull Application application) {
        super(application);
        repository = new TeamListRepository(application);
        allTeamLists = repository.getAllTeamLists();
    }
    public void insert(TeamList teamList) {
        repository.insert(teamList);
    }

    public void delete(TeamList teamList) {
        repository.delete(teamList);
    }

    public LiveData<List<TeamList>> getAllContacts() {
        return allTeamLists;
    }

}
