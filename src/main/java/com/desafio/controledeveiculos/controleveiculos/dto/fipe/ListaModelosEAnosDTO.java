package com.desafio.controledeveiculos.controleveiculos.dto.fipe;

import com.desafio.controledeveiculos.controleveiculos.dto.fipe.AnoDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.ModeloDTO;

import java.util.List;

public class ListaModelosEAnosDTO {

    List<ModeloDTO> modelos;
    List<AnoDTO> anos;

    public ListaModelosEAnosDTO() {
    }

    public ListaModelosEAnosDTO(List<ModeloDTO> modelos, List<AnoDTO> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    public List<ModeloDTO> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloDTO> modelos) {
        this.modelos = modelos;
    }

    public List<AnoDTO> getAnos() {
        return anos;
    }

    public void setAnos(List<AnoDTO> anos) {
        this.anos = anos;
    }
}
