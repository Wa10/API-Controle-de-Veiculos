package com.desafio.controledeveiculos.controleveiculos.dto;

import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;

import java.util.List;

public class VeiculosPorUsuarioDTO {

    private Usuario usuario;
    private List<Veiculo> veiculosPorUsuario;
    private boolean rodizioAtivo;

    public VeiculosPorUsuarioDTO() {
    }

    public VeiculosPorUsuarioDTO(Usuario usuario, List<Veiculo> veiculosPorUsuario) {
        this.usuario = usuario;
        this.veiculosPorUsuario = veiculosPorUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Veiculo> getVeiculosPorUsuario() {
        return veiculosPorUsuario;
    }

    public void setVeiculosPorUsuario(List<Veiculo> veiculosPorUsuario) {
        this.veiculosPorUsuario = veiculosPorUsuario;
    }
}
