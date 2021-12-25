package br.edu.ifrs.adotapet.model.dao.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifrs.adotapet.model.dao.AppDatabase;
import br.edu.ifrs.adotapet.model.dao.UserDAO;
import br.edu.ifrs.adotapet.model.User;

public class UserRepository {
    private UserDAO userDao;
    private LiveData<List<User>> AllUsers;
    private AppDatabase db;

    public UserRepository(Application application) {
        db = AppDatabase.getInstance(application.getApplicationContext());
        userDao = db.userDAO();
    }

    public LiveData<List<User>> getAllUser(){
        AllUsers = userDao.getAll();
        return AllUsers;
    }

    public void insert(User user){
        db.databaseWriteExecutor.execute(()->{
            userDao.insert(user);
        });
    }
}
