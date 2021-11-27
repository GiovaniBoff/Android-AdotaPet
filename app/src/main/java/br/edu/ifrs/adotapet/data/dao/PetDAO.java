package br.edu.ifrs.adotapet.data.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.edu.ifrs.adotapet.data.entity.Pet;

@Dao
public interface PetDAO {

    @Query("SELECT * FROM Pet")
    List<Pet> getAll();

    @Query("SELECT * FROM Pet WHERE Id = :ID")
    Pet getByID(int ID);

    @Insert(onConflict = REPLACE)
    void insert(Pet pet);

//    void update(Pet pet);


}
