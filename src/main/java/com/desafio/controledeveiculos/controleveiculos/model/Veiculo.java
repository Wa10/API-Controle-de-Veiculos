package com.desafio.controledeveiculos.controleveiculos.model;

import javax.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    @Column(name = "modelo_veiculo")
    private String modeloVeiculo;

    @Column(name = "ano_veiculo")
    private String anoVeiculo;

    private String valor;

    @Column(name = "dia_rodizio")
    private String diaRodizio;

    private Long idUsuario;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modeloVeiculo, String anoVeiculo, String valor,
                   String diaRodizio) {
        this.id = id;
        this.marca = marca;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.valor = valor;
        this.diaRodizio = diaRodizio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValor(){
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDiaRodizio() {
        return diaRodizio;
    }

    public void setDiaRodizio(String diaRodizio) {
        this.diaRodizio = diaRodizio;
    }
}
