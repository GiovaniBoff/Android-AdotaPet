package br.edu.ifrs.adotapet.model.dao.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;


import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.model.dao.AppDatabase;
import br.edu.ifrs.adotapet.model.dao.PetDAO;


public class PetRepository {
    private PetDAO mPetDao;
    private LiveData<List<Pet>> mAllPets;


    public PetRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        mPetDao = db.petDAO();
        mAllPets = mPetDao.getAll();
    }

    public LiveData<List<Pet>> getAllPets(){
        return mAllPets;
    }

    public Pet getPetById(int ID){
        Pet petSearched;
        petSearched = mPetDao.getByID(ID);
        return petSearched;
    }


    public void insert(Pet pet){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mPetDao.insert(pet);
        });
    }

    public void update(Pet pet){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mPetDao.insert(pet);
        });
    }

    public void delete(Pet pet){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mPetDao.delete(pet);
        });
    }


}
