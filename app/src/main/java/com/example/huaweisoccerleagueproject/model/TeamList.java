package com.example.huaweisoccerleagueproject.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teamlist_table")
public class TeamList {
    @PrimaryKey(autoGenerate = true)

    public int id;

    private String team1;
    private String team2;
    private String team3;
    private String team4;
    private String team5;
    private String team6;
    private String team7;
    private String team8;
    private String team9;
    private String team10;
    private String team11;
    private String team12;
    private String team13;
    private String team14;
    private String team15;
    private String team16;
    private String team17;
    private String team18;

    public TeamList(String team1 ,String team2, String team3, String team4, String team5 ,String team6, String team7, String team8, String team9 ,String team10, String team11, String team12, String team13 ,String team14, String team15, String team16, String team17 ,String team18){
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
        this.team5 = team5;
        this.team6 = team6;
        this.team7 = team7;
        this.team8 = team8;
        this.team9 = team9;
        this.team10 = team10;
        this.team11 = team11;
        this.team12 = team12;
        this.team13 = team13;
        this.team14 = team14;
        this.team15 = team15;
        this.team16 = team16;
        this.team17 = team17;
        this.team18 = team18;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTeam3() {
        return team3;
    }

    public String getTeam4() {
        return team4;
    }

    public String getTeam5() {
        return team5;
    }

    public String getTeam6() {
        return team6;
    }

    public String getTeam7() {
        return team7;
    }

    public String getTeam8() {
        return team8;
    }

    public String getTeam9() {
        return team9;
    }

    public String getTeam10() {
        return team10;
    }

    public String getTeam11() {
        return team11;
    }

    public String getTeam12() {
        return team12;
    }

    public String getTeam13() {
        return team13;
    }

    public String getTeam14() {
        return team14;
    }

    public String getTeam15() {
        return team15;
    }

    public String getTeam16() {
        return team16;
    }

    public String getTeam17() {
        return team17;
    }

    public String getTeam18() {
        return team18;
    }

}
