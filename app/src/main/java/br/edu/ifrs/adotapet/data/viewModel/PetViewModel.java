package br.edu.ifrs.adotapet.data.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifrs.adotapet.data.dao.repository.PetRepository;
import br.edu.ifrs.adotapet.data.entity.Pet;

public class PetViewModel extends AndroidViewModel {

    private PetRepository mRepository;
    private final LiveData<List<Pet>> mAllPets;

    public PetViewModel(@NonNull Application application) {
        super(application);
        mRepository =  new PetRepository(application);
        mAllPets = mRepository.getAllPets();
    }

    public LiveData<List<Pet>> getAllPets(){
        return mAllPets;
    }

    public void insert(Pet pet){
        mRepository.insert(pet);
    }
}
