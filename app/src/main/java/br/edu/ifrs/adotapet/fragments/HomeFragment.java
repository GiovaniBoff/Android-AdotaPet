package br.edu.ifrs.adotapet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifrs.adotapet.fragments.PetFragments.adapter.PetViewHolderAdapter;
import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.fragments.PetFragments.viewModel.PetViewModel;
import br.edu.ifrs.adotapet.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private PetViewHolderAdapter petAdapter;
    private PetViewModel petViewModel;
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        petViewModel = new ViewModelProvider(getActivity()).get(PetViewModel.class);

        configCardView();
        configPetDataObeservable(petAdapter);

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void configCardView() {
        petAdapter = new PetViewHolderAdapter(Pet.mockPets(),this.getContext(),petViewModel);
        binding.recyclerViewPets.setAdapter(petAdapter);
        binding.recyclerViewPets.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.recyclerViewPets.setLayoutManager(layoutManager);
    }

    private void configPetDataObeservable(PetViewHolderAdapter petAdapter){
        petViewModel.getAllPets().observe(getActivity(),pets -> {
            petAdapter.setPetsData(pets);
            petAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}