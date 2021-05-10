package com.example.huaweisoccerleagueproject.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.huaweisoccerleagueproject.model.TeamList;

import java.util.List;

@Dao
public interface TeamListDao {

    @Insert
    void insert(TeamList teamList);

    @Delete
    void delete(TeamList teamList);

    @Query("SELECT * FROM teamlist_table")
    LiveData<List<TeamList>> getAllTeamList();
}
