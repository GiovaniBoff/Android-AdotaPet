package br.edu.ifrs.adotapet.data.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String password;
    private Role role;
}
