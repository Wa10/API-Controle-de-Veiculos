package com.desafio.controledeveiculos.controleveiculos.repository;


import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.cpf = ?1")
    Optional<Usuario> produrarUsuarioPorCPF(String cpf);

    @Query("select u from Usuario u where u.email = ?1")
    Optional<Usuario> produrarUsuarioPorEmail(String email);

}
