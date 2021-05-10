package com.example.huaweisoccerleagueproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.huaweisoccerleagueproject.model.Fixture;
import com.example.huaweisoccerleagueproject.repository.FixtureRepository;

import java.util.List;

public class FixtureViewModel extends AndroidViewModel {

    private FixtureRepository repository;
    private LiveData<List<Fixture>> allFixtures;

    public FixtureViewModel(@NonNull Application application) {
        super(application);
        repository = new FixtureRepository(application);
        allFixtures = repository.getAllFixtures();
    }

    public void insert(Fixture fixture) {
        repository.insert(fixture);
    }

    public void delete(Fixture fixture) {
        repository.delete(fixture);
    }

    public LiveData<List<Fixture>> getAllFixtures() {
        return allFixtures;
    }
}
