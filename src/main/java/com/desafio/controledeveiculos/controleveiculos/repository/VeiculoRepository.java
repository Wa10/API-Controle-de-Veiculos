package com.desafio.controledeveiculos.controleveiculos.repository;

import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
