package com.example.huaweisoccerleagueproject.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fixture_table")
public class Fixture {

    @PrimaryKey(autoGenerate = true)
    //id private olması lazım bug oldu
    public int id;

    private String week;
    private String match1;
    private String match2;
    private String match3;
    private String match4;
    private String match5;
    private String match6;
    private String match7;
    private String match8;
    private String match9;

    public Fixture(String week ,String match1, String match2 ,String match3 ,String match4 ,String match5 ,String match6 ,String match7 ,String match8 ,String match9) {
        this.week = week;
        this.match1 = match1;
        this.match2 = match2;
        this.match3 = match3;
        this.match4 = match4;
        this.match5 = match5;
        this.match6 = match6;
        this.match7 = match7;
        this.match8 = match8;
        this.match9 = match9;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWeek() {
        return week;
    }

    public String getMatch1() {
        return match1;
    }

    public String getMatch2() {
        return match2;
    }

    public String getMatch3() {
        return match3;
    }

    public String getMatch4() {
        return match4;
    }

    public String getMatch5() {
        return match5;
    }

    public String getMatch6() {
        return match6;
    }

    public String getMatch7() {
        return match7;
    }

    public String getMatch8() {
        return match8;
    }

    public String getMatch9() {
        return match9;
    }


}
