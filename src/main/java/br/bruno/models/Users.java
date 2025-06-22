package br.bruno.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Users {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private boolean is_verify;
}
