package com.example.huaweisoccerleagueproject.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.huaweisoccerleagueproject.dao.TeamListDao;
import com.example.huaweisoccerleagueproject.model.TeamList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Database(entities = {TeamList.class}, version = 1)
public abstract class TeamListDatabase extends RoomDatabase {

    private static TeamListDatabase instance;

    private static Context activity;

    public abstract TeamListDao teamListDao();

    public static synchronized TeamListDatabase getInstance(Context context) {

        activity = context.getApplicationContext();

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TeamListDatabase.class, "teamlist_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private TeamListDao teamListDao;

        private PopulateDbAsyncTask(TeamListDatabase db) {
            teamListDao = db.teamListDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                fillWithStartingData(activity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static void fillWithStartingData(Context context) throws IOException {
        TeamListDao dao = getInstance(context).teamListDao();

        JSONArray teamlists = loadJSONArray(context);

        try {
            for (int i = 0; i < teamlists.length(); i++) {
                JSONObject teamlist = teamlists.getJSONObject(i);

                String team1 = teamlist.getString("team1");
                String team2 = teamlist.getString("team2");
                String team3 = teamlist.getString("team3");
                String team4 = teamlist.getString("team4");
                String team5 = teamlist.getString("team5");
                String team6 = teamlist.getString("team6");
                String team7 = teamlist.getString("team7");
                String team8 = teamlist.getString("team8");
                String team9 = teamlist.getString("team9");
                String team10 = teamlist.getString("team10");
                String team11 = teamlist.getString("team11");
                String team12 = teamlist.getString("team12");
                String team13 = teamlist.getString("team13");
                String team14 = teamlist.getString("team14");
                String team15 = teamlist.getString("team15");
                String team16 = teamlist.getString("team16");
                String team17 = teamlist.getString("team17");
                String team18 = teamlist.getString("team18");

                dao.insert(new TeamList(team1 ,team2 ,team3 ,team4 ,team5 ,team6 ,team7 ,team8 ,team9 ,team10 ,team11 ,team12, team13 ,team14 ,team15 ,team16 ,team17 ,team18));
            }
        }catch (JSONException e){

        }
    }

    private static JSONArray loadJSONArray (Context context) throws IOException {

        StringBuilder builder = new StringBuilder();
        URL url = new URL("https://raw.githubusercontent.com/FatihFe/json/main/teams");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = bin.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());

            return json.getJSONArray("teams");

        }catch (IOException | JSONException exeeption) {
            exeeption.printStackTrace();
        }
        return null;
    }
}
