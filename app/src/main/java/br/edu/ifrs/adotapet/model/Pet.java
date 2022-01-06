package br.edu.ifrs.adotapet.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String breed;
    private String size;

    public Pet() {
    }

    public Pet(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public Pet(String name, String breed, String size) {

        this.name = name;
        this.breed = breed;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public static List<Pet> mockPets(){
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("pet1", "raça1", "size1"));
        pets.add(new Pet("pet2", "raça2", "size2"));
        pets.add(new Pet("pet3", "raça3", "size3"));
        pets.add(new Pet("pet4", "raça4", "size4"));
        pets.add(new Pet("pet5", "raça5", "size5"));
        pets.add(new Pet("pet6", "raça6", "size6"));
        pets.add(new Pet("pet7", "raça7", "size7"));
        return pets;
    }
}
