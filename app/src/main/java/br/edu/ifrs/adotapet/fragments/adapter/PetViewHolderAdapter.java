package br.edu.ifrs.adotapet.fragments.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.ifrs.adotapet.R;
import br.edu.ifrs.adotapet.model.Pet;
import br.edu.ifrs.adotapet.fragments.viewModel.PetViewModel;

public class PetViewHolderAdapter extends RecyclerView.Adapter<PetViewHolderAdapter.ViewHolder> {
    List<Pet> petsData;
    Context context;
    PetViewModel petViewModel;
    public PetViewHolderAdapter(List<Pet> pets,Context context, PetViewModel petViewModel) {
        this.petsData = pets;
        this.context = context;
        this.petViewModel = petViewModel;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView petName;
        TextView petBreed;
        TextView petSize;
        ImageButton btnDelete;
        Button btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            petName = itemView.findViewById(R.id.textViewPetName);
            petBreed = itemView.findViewById(R.id.textViewPetBreed);
            petSize = itemView.findViewById(R.id.textViewPetSize);
            btnDelete = itemView.findViewById(R.id.btnExcluir);
        }
    }

    @NonNull
    @Override
    public PetViewHolderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View from = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_pet,parent,false);

        return new ViewHolder(from);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolderAdapter.ViewHolder holder, int position) {
        Pet pet = petsData.get(position);
        holder.petName.setText(pet.getName());
        holder.petBreed.setText(pet.getBreed());
        holder.petSize.setText(pet.getSize());

        holder.btnDelete.setOnClickListener(view -> {
            removePet(position);
        });

    }


    @Override
    public int getItemCount() {
        return petsData.size();
    }


    private void removePet(final int position){
        new AlertDialog.Builder(context)
                .setTitle("Deletando pet")
                .setMessage("Tem certeza que deseja deletar esse Item?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        petViewModel.delete(petsData.get(position));
                        notifyItemRemoved(position);

                    }}).setNegativeButton("Não", null).show();
    }

    public void setPetsData(List<Pet> pets){
        petsData = pets;
    }
}
