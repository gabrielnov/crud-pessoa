package br.com.mult3.Crud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter @Setter
public class Pessoa {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    @Size(min=2, max=30)
    private String nome;
    @NotNull @Min(18) @Max(120)
    private int idade;
    @NotNull @Email
    private String email;

}
