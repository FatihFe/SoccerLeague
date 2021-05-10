package com.example.huaweisoccerleagueproject.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.huaweisoccerleagueproject.dao.FixtureDao;
import com.example.huaweisoccerleagueproject.database.FixtureDatabase;
import com.example.huaweisoccerleagueproject.model.Fixture;

import java.util.List;

public class FixtureRepository {

    private FixtureDao fixtureDao;
    private LiveData<List<Fixture>> allFixtures;

    public FixtureRepository(Application application) {
        FixtureDatabase database = FixtureDatabase.getInstance(application);
        fixtureDao = database.fixtureDao();
        allFixtures = fixtureDao.getAllFixture();
    }

    public void insert(Fixture fixture) {
        new InsertFixtureAsyncTask(fixtureDao).execute(fixture);
    }

    public void delete(Fixture fixture) {
        new DeleteFixtureAsyncTask(fixtureDao).execute(fixture);
    }

    public  LiveData<List<Fixture>> getAllFixtures() {
        return allFixtures;
    }

    private static class InsertFixtureAsyncTask extends AsyncTask<Fixture, Void, Void> {
        private FixtureDao fixtureDao;

        private InsertFixtureAsyncTask(FixtureDao fixtureDao) {
            this.fixtureDao = fixtureDao;
        }

        @Override
        protected Void doInBackground(Fixture... fixtures) {
            fixtureDao.insert(fixtures[0]);
            return null;
        }
    }

    private static class DeleteFixtureAsyncTask extends AsyncTask<Fixture, Void, Void> {
        private FixtureDao fixtureDao;

        private DeleteFixtureAsyncTask(FixtureDao fixtureDao) {
            this.fixtureDao = fixtureDao;
        }

        @Override
        protected Void doInBackground(Fixture... fixtures) {
            fixtureDao.delete(fixtures[0]);
            return null;
        }
    }

}
