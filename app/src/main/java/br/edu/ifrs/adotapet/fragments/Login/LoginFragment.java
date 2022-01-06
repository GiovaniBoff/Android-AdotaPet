package br.edu.ifrs.adotapet.fragments.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        Button btnLogin = root.findViewById(R.id.btnLogar);

        btnLogin.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_login_to_nav_home);
        });

        return root;
    }
}
