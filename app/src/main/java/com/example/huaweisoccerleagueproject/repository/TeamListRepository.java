package com.example.huaweisoccerleagueproject.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.huaweisoccerleagueproject.dao.TeamListDao;
import com.example.huaweisoccerleagueproject.database.TeamListDatabase;
import com.example.huaweisoccerleagueproject.model.TeamList;

import java.util.List;

public class TeamListRepository {

    private TeamListDao teamListDao;
    private LiveData<List<TeamList>> allTeamLists;

    public TeamListRepository(Application application) {
        TeamListDatabase database = TeamListDatabase.getInstance(application);
        teamListDao = database.teamListDao();
        allTeamLists = teamListDao.getAllTeamList();
    }

    public void insert(TeamList teamList) {
        new InsertTeamListAsyncTask(teamListDao).execute(teamList);
    }

    public void delete(TeamList teamList) {
        new DeleteTeamListAsyncTask(teamListDao).execute(teamList);
    }

    public LiveData<List<TeamList>> getAllTeamLists() {
        return allTeamLists;
    }

    private static class InsertTeamListAsyncTask extends AsyncTask<TeamList, Void, Void> {
        private TeamListDao teamListDao;

        private InsertTeamListAsyncTask(TeamListDao teamListDao) {
            this.teamListDao = teamListDao;
        }

        @Override
        protected Void doInBackground(TeamList... teamLists) {
            teamListDao.insert(teamLists[0]);
            return null;
        }
    }

    private static class DeleteTeamListAsyncTask extends AsyncTask<TeamList, Void, Void> {
        private TeamListDao teamListDao;

        private DeleteTeamListAsyncTask(TeamListDao teamListDao) {
            this.teamListDao = teamListDao;
        }

        @Override
        protected Void doInBackground(TeamList... teamLists) {
            teamListDao.delete(teamLists[0]);
            return null;
        }
    }
}
