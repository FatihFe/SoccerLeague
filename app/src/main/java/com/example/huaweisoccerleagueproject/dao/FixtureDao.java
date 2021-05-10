package com.example.huaweisoccerleagueproject.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.huaweisoccerleagueproject.model.Fixture;

import java.util.List;

@Dao
public interface FixtureDao {

    @Insert
    void insert(Fixture fixture);

    @Delete
    void delete(Fixture fixture);

    @Query("SELECT * FROM fixture_table")
    LiveData<List<Fixture>> getAllFixture();
}
