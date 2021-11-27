package br.edu.ifrs.adotapet.data.dao.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifrs.adotapet.data.dao.AppDatabase;
import br.edu.ifrs.adotapet.data.dao.UserDAO;
import br.edu.ifrs.adotapet.data.entity.User;

public class UserRepository {
    private UserDAO userDao;
    private LiveData<List<User>> AllUsers;
    private AppDatabase db;

    public UserRepository(Application application) {
        db = AppDatabase.getInstance(application.getApplicationContext());
        userDao = db.userDAO();
    }

    LiveData<List<User>> getAllUser(){
        AllUsers = userDao.getAll();
        return AllUsers;
    }

    void insert(User user){
        db.databaseWriteExecutor.execute(()->{
            userDao.insert(user);
        });
    }
}
