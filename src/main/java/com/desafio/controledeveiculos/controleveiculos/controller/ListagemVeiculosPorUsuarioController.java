package com.desafio.controledeveiculos.controleveiculos.controller;

import com.desafio.controledeveiculos.controleveiculos.dto.VeiculosPorUsuarioDTO;
import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import com.desafio.controledeveiculos.controleveiculos.service.UsuarioService;
import com.desafio.controledeveiculos.controleveiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listagem")
public class ListagemVeiculosPorUsuarioController {

    private final UsuarioService usuarioService;
    private final VeiculoService veiculoService;


    public ListagemVeiculosPorUsuarioController(UsuarioService usuarioService, VeiculoService veiculoService) {
        this.usuarioService = usuarioService;
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VeiculosPorUsuarioDTO> listar(@PathVariable Long id){
        VeiculosPorUsuarioDTO listarVeiculosPorUsuario = new VeiculosPorUsuarioDTO();

        Optional<Usuario> usuario = usuarioService.procurarPorID(id);

        if(usuario.isPresent()) {
            List<Veiculo> v = veiculoService.listarVeiculosPorUsuario(id);

            listarVeiculosPorUsuario.setUsuario(usuario.get());
            listarVeiculosPorUsuario.setVeiculosPorUsuario(v);

            return ResponseEntity.status(HttpStatus.OK).body(listarVeiculosPorUsuario);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuario não encontrado"
            );
        }
    }
}
