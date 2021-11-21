package br.edu.ifrs.adotapet.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Pet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String breed;
    private String size;

}
