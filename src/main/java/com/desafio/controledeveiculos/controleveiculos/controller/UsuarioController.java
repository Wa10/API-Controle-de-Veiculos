package com.desafio.controledeveiculos.controleveiculos.controller;

import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> procurarTodos(){
        return usuarioService.procurarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        usuarioService.deletarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody @Valid Usuario usuario, @PathVariable Long id){
        usuarioService.atualizar(usuario, id);
    }


}
