package com.desafio.controledeveiculos.controleveiculos.service;

import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> procurarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletarUsuarioPorId(Long id) {
        usuarioRepository.findById(id)
                .map(cliente -> {
                    usuarioRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com o id " + id + " não encontrado!"));
    }


    public void atualizar(Usuario usuario, Long id){
        usuarioRepository.findById(id)
                .map(usuarioEncontrado -> {

                    usuarioEncontrado.setCpf(usuario.getCpf());
                    usuarioEncontrado.setEmail(usuario.getEmail());

                    if(usuario.getDataNascimento() != null)
                    usuarioEncontrado.setDataNascimento(usuario.getDataNascimento());

                    if(usuario.getNome() != null){
                        usuarioEncontrado.setNome(usuario.getNome());
                    }

                    return usuarioRepository.save(usuarioEncontrado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com o id " + id + " não encontrado!"));
    }


}



