package br.edu.ifrs.adotapet.data.dao.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifrs.adotapet.data.dao.AppDatabase;
import br.edu.ifrs.adotapet.data.dao.PetDAO;
import br.edu.ifrs.adotapet.data.entity.Pet;

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

    public void insert(Pet pet){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mPetDao.insert(pet);
        });
    }
}
