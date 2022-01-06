package br.edu.ifrs.adotapet.fragments.PetFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.fragments.PetFragments.viewModel.PetViewModel;
import br.edu.ifrs.adotapet.databinding.FragmentAddPetBinding;


public class AddPetFragment extends Fragment {

    private FragmentAddPetBinding binding;
    private PetViewModel petViewModel;

    private TextInputLayout inputLayoutPetName;
    private TextInputLayout inputLayoutPetBreed;

    private Editable petName;
    private Editable petBreed;
    private String petSize;

    private Boolean fieldsAreFilled = true;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddPetBinding
                .inflate(inflater, container,false);
        petViewModel = new ViewModelProvider(requireActivity()).get(PetViewModel.class);
        configFields();
        configClickListenerSubmitPet();

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void configFields() {
        inputLayoutPetName = binding.layoutPetName;
        inputLayoutPetBreed = binding.layoutPetBreed;
        petName = binding.txtPetName.getText();
        petBreed = binding.txtPetBreed.getText();
        petSize = binding.spinnerPetSize.getItemAtPosition(binding.spinnerPetSize.getSelectedItemPosition()).toString();
    }

    private void configClickListenerSubmitPet(){
        binding.btnSave.setOnClickListener((View view) -> {
            validatePetName();
            validatePetBreed();
            if(fieldsAreFilled){
                Log.i(getTag(), "--------------------> "+binding.spinnerPetSize.getItemAtPosition(binding.spinnerPetSize.getSelectedItemPosition()).toString());
                Pet pet = new Pet(petName.toString(),petBreed.toString(),binding.spinnerPetSize.getItemAtPosition(binding.spinnerPetSize.getSelectedItemPosition()).toString());
                petViewModel.insert(pet);
                Snackbar.make(view, "Pet Cadastrado com Sucesso!",BaseTransientBottomBar.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_addPetFragment_to_nav_home);
            }else{
                Snackbar.make(view, "Erro ao cadasto do Pet,Preencha corretamente os campos!",BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }


    private void setFieldsMessage(TextInputLayout layout ,String msg, boolean state){
        layout.setErrorEnabled(true);
        layout.setError(msg);
    }

    private void validatePetName(){
        if(petName.toString().isEmpty()){
            setFieldsMessage(inputLayoutPetName,"O nome do pet deve ser preenchido",true);
            fieldsAreFilled = false;
        }else{
            setFieldsMessage(inputLayoutPetName,"",false);
            fieldsAreFilled = true;
        }

    }

    private void validatePetBreed(){
        if(petBreed.toString().isEmpty()){
            setFieldsMessage(inputLayoutPetBreed,"A raça do pet deve ser preenchida",true);
            fieldsAreFilled = false;
        }else{
            setFieldsMessage(inputLayoutPetBreed,"",false);
            fieldsAreFilled = true;
        }

    }
}