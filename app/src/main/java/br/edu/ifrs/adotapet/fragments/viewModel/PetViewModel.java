package br.edu.ifrs.adotapet.fragments.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.edu.ifrs.adotapet.model.dao.repository.PetRepository;
import br.edu.ifrs.adotapet.model.Pet;

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

    public Pet getPetById(int id){
        return  mRepository.getPetById(id);
    }
    public void insert(Pet pet){
        mRepository.insert(pet);
    }

    public void update(Pet pet) { mRepository.update(pet);}

    public void delete(Pet pet) { mRepository.delete(pet);}


}
