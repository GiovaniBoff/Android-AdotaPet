package br.edu.ifrs.adotapet.model.dao;



import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.edu.ifrs.adotapet.model.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM User WHERE Id = :ID")
    User getByID(int ID);

    @Insert(onConflict = REPLACE)
    void insert(User user);

//    void update(User user);



}
