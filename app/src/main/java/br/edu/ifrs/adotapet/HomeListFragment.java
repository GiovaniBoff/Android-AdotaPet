package br.edu.ifrs.adotapet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.edu.ifrs.adotapet.databinding.FragmentHomeListBinding;


public class HomeListFragment extends Fragment {

    private FragmentHomeListBinding binding;
    private NavController navController;

    public HomeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_home_list, container, false);

        binding = FragmentHomeListBinding.inflate(inflater,container,false);

        String[] menuOptions = new String[]{"Registrar Pets", "Listar Pets","Sobre AdotaPets"};
        View root = binding.getRoot();


        ListView listView = root.findViewById(R.id.listView_menu);
        navController = NavHostFragment.findNavController(this);

        ArrayAdapter<String> menuList = new ArrayAdapter<>(root.getContext(), android.R.layout.simple_list_item_1, menuOptions);
        listView.setAdapter(menuList);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            String menuItem = (String) parent.getItemAtPosition(position);
            if (menuItem.equals("Registrar Pets")) {
                navController.navigate(R.id.action_homeListFragment_to_addPetFragment);
            }

            if (menuItem.equals("Listar Pets")) {
                navController.navigate(R.id.action_homeListFragment_to_listPetFragment);
            }

            if (menuItem.equals("Sobre AdotaPets")) {
                Uri flashCardsUri = Uri.parse("https://www.adotepetz.com.br/");
                Intent intent = new Intent(Intent.ACTION_VIEW, flashCardsUri);
                startActivity(intent);
            }


        });


        return root;
    }
}