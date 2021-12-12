package br.edu.ifrs.adotapet.ui.home;

import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.data.dao.AppDatabase;
import br.edu.ifrs.adotapet.data.dao.PetDAO;
import br.edu.ifrs.adotapet.data.entity.Pet;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPetFragment extends Fragment {

    PetDAO petDAO;
    private AppDatabase db;
    public EditPetFragment() {
        // Required empty public constructor
    }


    public static EditPetFragment newInstance() {
        EditPetFragment fragment = new EditPetFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = AppDatabase.getInstance(getContext());
        petDAO = db.petDAO();
    }

    public void configClickSave(){



    }

    public void savePet(Pet pet){
        petDAO.insert(pet);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_edit_pet, container, false);
    }
}