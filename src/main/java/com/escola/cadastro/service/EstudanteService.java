package com.escola.cadastro.service;

import com.escola.cadastro.model.dto.EstudanteDTO;
import com.escola.cadastro.model.entity.Estudante;
import com.escola.cadastro.repository.EstudanteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    //GET
    public ResponseEntity<List<Estudante>> listarEstudantes() {
        return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.findAll());
    }

    //POST
    public ResponseEntity<Estudante> criarEstudante(EstudanteDTO dto) {
        Estudante novoEstudante = new Estudante();
        novoEstudante.setNome(dto.getNome());
        novoEstudante.setDataNascimento(dto.getDataNascimento());
        novoEstudante.setSituacaoCadastro(true);
        estudanteRepository.save(novoEstudante);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstudante);
    }

    //PUT
    public ResponseEntity<Estudante> editarEstudante(Long id, EstudanteDTO estudante) {
        return estudanteRepository.findById(id)
                .map(estudantes -> {
                    estudantes.setNome(estudante.getNome());
                    estudantes.setDataNascimento(estudante.getDataNascimento());

                    estudanteRepository.save(estudantes);

                    return ResponseEntity.ok(estudantes);
                }).orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    public ResponseEntity<Void> excluirEstudante(Long id) {
        if(estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
