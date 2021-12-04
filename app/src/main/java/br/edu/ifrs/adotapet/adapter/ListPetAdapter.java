package br.edu.ifrs.adotapet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.data.entity.Pet;

public class ListPetAdapter extends RecyclerView.Adapter<ListPetAdapter.ViewHolder> {
    List<Pet> petsData = new ArrayList<>();

    public ListPetAdapter(List<Pet> pets) {
        this.petsData = pets;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView petName;
        TextView petBreed;
        TextView petSize;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            petName = itemView.findViewById(R.id.textViewPetName);
            petBreed = itemView.findViewById(R.id.textViewPetBreed);
            petSize = itemView.findViewById(R.id.textViewPetSize);
        }
    }

    @NonNull
    @Override
    public ListPetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View from = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_pet,parent,false);

        return new ViewHolder(from);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPetAdapter.ViewHolder holder, int position) {
        Pet pet = petsData.get(position);
        holder.petName.setText(pet.getName());
        holder.petBreed.setText(pet.getBreed());
        holder.petSize.setText(pet.getSize());
    }

    @Override
    public int getItemCount() {
        return petsData.size();
    }


}
