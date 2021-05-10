package com.example.huaweisoccerleagueproject.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.huaweisoccerleagueproject.dao.FixtureDao;
import com.example.huaweisoccerleagueproject.model.Fixture;

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

@Database(entities = {Fixture.class}, version = 1)
public abstract class FixtureDatabase extends RoomDatabase {

    private static FixtureDatabase instance;

    private static Context activity;

    public abstract FixtureDao fixtureDao();

    public static synchronized FixtureDatabase getInstance(Context context) {

        activity = context.getApplicationContext();

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FixtureDatabase.class, "fixture_database")
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

    private static class  PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private FixtureDao fixtureDao;
        private PopulateDbAsyncTask(FixtureDatabase db) {
            fixtureDao = db.fixtureDao();
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
        FixtureDao dao = getInstance(context).fixtureDao();

        JSONArray fixtures = loadJSONArray(context);

        try {
            for (int i = 0; i < fixtures.length(); i++) {
                JSONObject fixture = fixtures.getJSONObject(i);

                String week = fixture.getString("week");
                String match1 = fixture.getString("match1");
                String match2 = fixture.getString("match2");
                String match3 = fixture.getString("match3");
                String match4 = fixture.getString("match4");
                String match5 = fixture.getString("match5");
                String match6 = fixture.getString("match6");
                String match7 = fixture.getString("match7");
                String match8 = fixture.getString("match8");
                String match9 = fixture.getString("match9");

                dao.insert(new Fixture(week ,match1, match2, match3, match4, match5, match6, match7, match8,match9));
            }
        } catch (JSONException e) {

        }
    }

    private static JSONArray loadJSONArray (Context context) throws IOException {

        StringBuilder builder = new StringBuilder();

        URL url = new URL("https://raw.githubusercontent.com/FatihFe/json/main/mocksoccerleague.json");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));

        String line;

        try {
            while ((line = bin.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());

            return json.getJSONArray("fixture");

        }catch (IOException | JSONException exeeption) {
            exeeption.printStackTrace();
        }
        return null;
    }
}
