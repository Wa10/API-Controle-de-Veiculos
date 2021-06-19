package com.desafio.controledeveiculos.controleveiculos.repository;


import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
