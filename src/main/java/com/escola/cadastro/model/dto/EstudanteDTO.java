package com.escola.cadastro.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class EstudanteDTO {
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private boolean situacaoCadastro;
}

