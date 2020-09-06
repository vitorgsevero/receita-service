package com.vitorgsevero.io.receitaapi.repository;

import com.vitorgsevero.io.receitaapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
