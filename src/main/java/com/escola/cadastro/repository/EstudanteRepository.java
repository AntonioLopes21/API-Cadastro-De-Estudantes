package com.escola.cadastro.repository;

import com.escola.cadastro.model.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
