package br.edu.ifrs.adotapet.fragments.Login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifrs.adotapet.model.dao.repository.UserRepository;
import br.edu.ifrs.adotapet.databinding.FragmentRegistrationBinding;


public class RegistrationFragment extends Fragment {

    private UserRepository userRepository;
    private FragmentRegistrationBinding binding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentRegistrationBinding.inflate(inflater,container,false);

        View root = binding.getRoot();

        return root;
    }
}