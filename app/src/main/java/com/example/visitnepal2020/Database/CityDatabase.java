package com.example.visitnepal2020.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {City.class}, version = 1)
public abstract class CityDatabase extends RoomDatabase {
    private static CityDatabase instance;
    public abstract CityDao cityDao();

    public static synchronized CityDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CityDatabase.class, "city_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CityDao cityDao;

        private PopulateDbAsyncTask(CityDatabase db) {
            cityDao = db.cityDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cityDao.insert(new City("Kathmandu", "https://visitnepal2020.com/images/exp-dance.jpg"));
            cityDao.insert(new City("Bhaktapur", "https://visitnepal2020.com/images/exp-craft.jpg"));
            cityDao.insert(new City("Pokhara", "https://visitnepal2020.com/images/exp-adventure.jpg"));
//            cityDao.insert(new City("Chitwan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTd7j7-2CiMIiixKlDlu3SLB3NrjKzV8A1T08Zd91j8Pjlsxg8cIw&s"));
//            cityDao.insert(new City("swayambhunath", "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F1161006287%2F960x0.jpg%3Ffit%3Dscale"));
//            cityDao.insert(new City("Ghandruk", "https://tmmnepal.com/images/package-thumbnails/2019042507-mWxdOA.jpg"));
//            cityDao.insert(new City("Syangja", "https://sworektapu.weebly.com/uploads/2/8/1/4/28142499/4667002_orig.jpg"));
//            cityDao.insert(new City("Mt. Everest", "https://s26626.pcdn.co/wp-content/uploads/2019/03/safety-nepal.jpg.optimal.jpg"));

            return null;
        }
    }
}
