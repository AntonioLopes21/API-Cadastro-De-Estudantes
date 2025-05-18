package com.escola.cadastro.controller;

import com.escola.cadastro.model.dto.EstudanteDTO;
import com.escola.cadastro.model.entity.Estudante;
import com.escola.cadastro.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteService estudanteService;
    //
    @GetMapping
    public ResponseEntity<List<Estudante>> listar() {
        return estudanteService.listarEstudantes();
    }

    @PostMapping
    public ResponseEntity<Estudante> criar(@RequestBody EstudanteDTO dto){
        return estudanteService.criarEstudante(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> editar(@PathVariable Long id, @RequestBody EstudanteDTO estudante) {
        return estudanteService.editarEstudante(id, estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return estudanteService.excluirEstudante(id);
    }
}
