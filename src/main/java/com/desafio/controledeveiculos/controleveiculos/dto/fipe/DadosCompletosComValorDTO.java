package com.desafio.controledeveiculos.controleveiculos.dto.fipe;

public class DadosCompletosComValorDTO {
    private String Valor;
    private String Marca;
    private String Modelo;
    private Integer AnoModelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private Integer TipoVeiculo;
    private String SiglaCombustivel;

    public DadosCompletosComValorDTO() { }

    public DadosCompletosComValorDTO(
            String valor, String marca, String modelo, Integer anoModelo,
            String combustivel, String codigoFipe, String mesReferencia,
            Integer tipoVeiculo, String siglaCombustivel) {
        Valor = valor;
        Marca = marca;
        Modelo = modelo;
        AnoModelo = anoModelo;
        Combustivel = combustivel;
        CodigoFipe = codigoFipe;
        MesReferencia = mesReferencia;
        TipoVeiculo = tipoVeiculo;
        SiglaCombustivel = siglaCombustivel;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public Integer getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        AnoModelo = anoModelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public void setCombustivel(String combustivel) {
        Combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        CodigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        MesReferencia = mesReferencia;
    }

    public Integer getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        SiglaCombustivel = siglaCombustivel;
    }

    @Override
    public String toString() {
        return "DadosCompletosComValorDTO{" +
                "Valor='" + Valor + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", AnoModelo='" + AnoModelo + '\'' +
                ", Combustivel='" + Combustivel + '\'' +
                ", CodigoFipe='" + CodigoFipe + '\'' +
                ", MesReferencia='" + MesReferencia + '\'' +
                ", TipoVeiculo='" + TipoVeiculo + '\'' +
                ", SiglaCombustivel='" + SiglaCombustivel + '\'' +
                '}';
    }
}
