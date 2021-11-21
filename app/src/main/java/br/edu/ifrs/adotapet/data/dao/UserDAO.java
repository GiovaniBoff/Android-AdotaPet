package br.edu.ifrs.adotapet.data.dao;



import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.edu.ifrs.adotapet.data.entity.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE Id")
    void getByID(int ID);

    @Insert(onConflict = REPLACE)
    void insert(User user);

    void update(User user);



}
