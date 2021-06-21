package com.desafio.controledeveiculos.controleveiculos.service;

import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario) {
        Optional<Usuario> usuarioComCPF = usuarioRepository.procurarUsuarioPorCPF(usuario.getCpf());
        Optional<Usuario> usuarioComEmail = usuarioRepository.procurarUsuarioPorEmail(usuario.getEmail());

        if(usuarioComEmail.isPresent() && usuarioComCPF.isPresent()){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF e Email duplicados");
        }

        if(usuarioComCPF.isPresent()){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF duplicado");
        }

        if(usuarioComEmail.isPresent()){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email duplicado");
        }
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> procurarPorID(Long id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> procurarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletarUsuarioPorId(Long id) {
        usuarioRepository.findById(id)
                .map(cliente -> {
                    usuarioRepository.delete(cliente);
                    return Void.TYPE; })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com o id " + id + " não encontrado!"));
    }

    public void atualizar(Usuario usuario, Long id){
        usuarioRepository.findById(id)
                .map(usuarioEncontrado -> {
                    usuarioEncontrado.setCpf(usuario.getCpf());
                    usuarioEncontrado.setEmail(usuario.getEmail());
                    if(usuario.getDataNascimento() != null) {usuarioEncontrado.setDataNascimento(usuario.getDataNascimento());}
                    if(usuario.getNome() != null){usuarioEncontrado.setNome(usuario.getNome());}

                    return usuarioRepository.save(usuarioEncontrado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com o id " + id + " não encontrado!"));
    }


}



