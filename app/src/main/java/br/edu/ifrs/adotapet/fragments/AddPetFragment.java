package br.edu.ifrs.adotapet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.fragments.viewModel.PetViewModel;
import br.edu.ifrs.adotapet.databinding.FragmentAddPetBinding;


public class AddPetFragment extends Fragment {

    private FragmentAddPetBinding binding;
    private PetViewModel petViewModel;

    //Layouts
    private TextInputLayout lPetName;
    private TextInputLayout lPetBreed;

    //Fields
    private String petName;
    private String petBreed;
    private String petSize;




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
        inflater.inflate(R.layout.fragment_add_pet, container, false);
        configBiding(inflater, container);
        configFields();
        configLayouts();
        configClickListenerSubmitPet();
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void configBiding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentAddPetBinding
                .inflate(inflater, container,false);
        petViewModel = new ViewModelProvider(getActivity()).get(PetViewModel.class);
    }

    private void configLayouts(){
        lPetName = binding.layoutPetName;
        lPetBreed = binding.layoutPetBreed;
    }


    private void configFields() {
        petName = binding.txtPetName.getText().toString();
        petBreed = binding.txtPetBreed.getText().toString();
        //petBreed = binding.spinnerPetBreed.toString();
    }

    private void configClickListenerSubmitPet(){
        binding.btnSave.setOnClickListener((View v) -> {
            if(validateFields()){
                Pet pet = new Pet(petName,petBreed);
                petViewModel.insert(pet);
                Snackbar.make(v, "Pet Cadastrado com Sucesso!",BaseTransientBottomBar.LENGTH_SHORT).show();
            }else{
                Snackbar.make(v, "Erro ao cadasto do Pet,Preencha corretamente os campos!",BaseTransientBottomBar.LENGTH_SHORT).show();
            }

        });
    }

    private boolean validateFields(){
//        if(petName.isEmpty()){
//            lPetName.setErrorEnabled(true);
//            lPetName.setError("Informe o nome do Pet!!");
//            return false;
//        }
//        if(petBreed.isEmpty()){
//            lPetBreed.setErrorEnabled(true);
//            lPetBreed.setError("Informe a raça do Pet!!");
//            return false;
//        }
//        lPetBreed.setErrorEnabled(false);
//        lPetName.setErrorEnabled(false);
        return true;
    }
}