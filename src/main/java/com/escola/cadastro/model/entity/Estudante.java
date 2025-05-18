package com.escola.cadastro.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "estudante")
@Getter
@Setter
@RequiredArgsConstructor
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "O nome não pode ser vazio.")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória.")
    //"yyyy-MM-dd"
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = "A situação do cadastro é obrigatória.")
    @Column(name = "situacao_cadastro")
    private Boolean situacaoCadastro;
}
