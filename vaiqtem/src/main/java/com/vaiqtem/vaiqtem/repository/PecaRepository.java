package com.vaiqtem.vaiqtem.repository;

import com.vaiqtem.vaiqtem.domain.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
    List<Peca> findByCondicao(String condicao);  // Buscar peças novas ou usadas
}
