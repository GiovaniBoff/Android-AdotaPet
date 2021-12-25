package br.edu.ifrs.adotapet.model.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.ifrs.adotapet.model.Pet;


@Dao
public interface PetDAO {

    @Query("SELECT * FROM Pet")
    LiveData<List<Pet>> getAll();

    @Query("SELECT * FROM Pet WHERE Id = :ID")
    Pet getByID(int ID);

    @Insert(onConflict = REPLACE)
    void insert(Pet pet);

    @Update
    void update(Pet pet);

    @Delete
    void delete(Pet pet);

}
