package br.edu.ifrs.adotapet.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.data.entity.Pet;
import br.edu.ifrs.adotapet.data.viewModel.PetViewModel;
import br.edu.ifrs.adotapet.databinding.FragmentAddPetBinding;


public class AddPetFragment extends Fragment {

    private FragmentAddPetBinding binding;
    private PetViewModel petViewModel;

    String petName;
    String petBreed;
    String petSize;

    public AddPetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_add_pet, container, false);

        binding = FragmentAddPetBinding.inflate(inflater,container,false);
        petViewModel = new ViewModelProvider(getActivity()).get(PetViewModel.class);

        configClickListenerSubmitPet();

        View root = binding.getRoot();
        return root;
    }


    private void configClickListenerSubmitPet(){

        //petBreed = binding.spinnerPetBreed.toString();


        binding.buttonSave.setOnClickListener((View v) -> {
            petName = binding.editTextPetName.getText().toString();
            petSize = binding.editTextPetSize.getText().toString();
            Pet pet = new Pet(petName,petSize);
            petViewModel.insert(pet);
            Snackbar.make(v, "Cadastrado com Sucesso!",BaseTransientBottomBar.LENGTH_SHORT).show();
        });
    }
}