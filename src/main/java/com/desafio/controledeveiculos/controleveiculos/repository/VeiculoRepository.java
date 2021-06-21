package com.desafio.controledeveiculos.controleveiculos.repository;

import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("select v from Veiculo v where v.idUsuario = ?1")
    List<Veiculo> listarVeiculosPorUsuario(Long id);
}
