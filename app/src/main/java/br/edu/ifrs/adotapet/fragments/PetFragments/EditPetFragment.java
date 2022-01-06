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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.databinding.FragmentEditPetBinding;
import br.edu.ifrs.adotapet.fragments.PetFragments.viewModel.PetViewModel;
import br.edu.ifrs.adotapet.model.Pet;


public class EditPetFragment extends Fragment {

    private FragmentEditPetBinding binding;
    private PetViewModel petViewModel;

    Pet pet;

    private TextInputLayout inputLayoutPetName;
    private TextInputLayout inputLayoutPetBreed;

    private TextInputEditText petName;
    private TextInputEditText petBreed;
    private Spinner petSize;

    private Editable petNameUpdated;
    private Editable petBreedUpdated;
    private String petSizeUpdate;

    private List<String> sizesArray;

    private Boolean fieldsAreFilled = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEditPetBinding.inflate(inflater, container,false);
        petViewModel = new ViewModelProvider(requireActivity()).get(PetViewModel.class);
        sizesArray = Arrays.asList(getResources().getStringArray(R.array.sizes_array));
        configFields();
        configBundleData();
        configFieldsData();
        configUpdatedData();
        configClickListenerSubmitPet();
        return binding.getRoot();
    }

    private void configFields() {
        inputLayoutPetName = binding.layoutPetName;
        inputLayoutPetBreed = binding.layoutPetBreed;
        petName = binding.txtPetName;
        petBreed = binding.txtPetBreed;
        petSize = binding.spinnerPetSize;
    }

    private void configUpdatedData(){
        petNameUpdated = binding.txtPetName.getText();
        petBreedUpdated = binding.txtPetBreed.getText();
    }

    private void configBundleData(){
        pet = (Pet)getArguments().getSerializable("Pet");
    }

    private void configFieldsData(){
        petName.setText(pet.getName());
        petBreed.setText(pet.getBreed());
        int i = sizesArray.indexOf(pet.getSize());
        petSize.setSelection(i);
    }

    private void validatePetName(){
        if(petNameUpdated.toString().isEmpty()){
            setFieldsMessage(inputLayoutPetName,"O nome do pet deve ser preenchido",true);
            fieldsAreFilled = false;
        }else{
            setFieldsMessage(inputLayoutPetName,"",false);
            fieldsAreFilled = true;
        }

    }

    private void setFieldsMessage(TextInputLayout layout ,String msg, boolean state){
        layout.setErrorEnabled(true);
        layout.setError(msg);
    }

    private void validatePetBreed(){
        if(petBreedUpdated.toString().isEmpty()){
            setFieldsMessage(inputLayoutPetBreed,"A raça do pet deve ser preenchida",true);
            fieldsAreFilled = false;
        }else{
            setFieldsMessage(inputLayoutPetBreed,"",false);
            fieldsAreFilled = true;
        }

    }

    private void configClickListenerSubmitPet(){
        binding.btnSave.setOnClickListener((View view) -> {
            validatePetName();
            validatePetBreed();
            if(fieldsAreFilled){
                Log.i(getTag(), "--------------------> "+binding.spinnerPetSize.getItemAtPosition(binding.spinnerPetSize.getSelectedItemPosition()).toString());
                setUpdatedPetData(petNameUpdated.toString(),petBreedUpdated.toString(),binding.spinnerPetSize.getItemAtPosition(binding.spinnerPetSize.getSelectedItemPosition()).toString());
                petViewModel.update(pet);
                Snackbar.make(view, "Pet atualizado com Sucesso!", BaseTransientBottomBar.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_editPetFragment_to_nav_home);
            }else{
                Snackbar.make(view, "Erro ao atualizar do Pet,Preencha corretamente os campos!",BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }

    public void setUpdatedPetData(String petName, String petBreed, String petSize){
        pet.setName(petName);
        pet.setBreed(petBreed);
        pet.setSize(petSize);
    }

}