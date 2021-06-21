package com.desafio.controledeveiculos.controleveiculos.controller;

import com.desafio.controledeveiculos.controleveiculos.dto.VeiculoDTO;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import com.desafio.controledeveiculos.controleveiculos.service.VeiculoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    public final VeiculoService veiculoService;

    public VeiculosController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> procurarTodos(){
        return veiculoService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid VeiculoDTO veiculoDTO){
        veiculoService.salvar(veiculoDTO);
    }


}
