package com.desafio.controledeveiculos.controleveiculos.dto;

import javax.validation.constraints.NotEmpty;

public class VeiculoDTO {

    @NotEmpty
    private String marca;

    @NotEmpty
    private String modeloVeiculo;

    @NotEmpty
    private String anoVeiculo;

    private Long idUsuario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String marca, String modeloVeiculo, String anoVeiculo, Long idUsuario) {
        this.marca = marca;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.idUsuario = idUsuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "VeiculoDTO{" +
                "marca='" + marca + '\'' +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", anoVeiculo='" + anoVeiculo + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
