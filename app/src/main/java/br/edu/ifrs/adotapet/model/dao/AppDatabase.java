package br.edu.ifrs.adotapet.model.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.model.User;

@Database(entities = {User.class, Pet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    public static ExecutorService databaseWriteExecutor=
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public abstract UserDAO userDAO();
    public abstract PetDAO petDAO();

    public static AppDatabase getInstance(Context context) {
        if(appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "driver_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }
}


