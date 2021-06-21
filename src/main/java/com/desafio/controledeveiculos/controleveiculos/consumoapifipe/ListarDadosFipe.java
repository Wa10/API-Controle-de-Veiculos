package com.desafio.controledeveiculos.controleveiculos.consumoapifipe;


import com.desafio.controledeveiculos.controleveiculos.dto.fipe.AnoDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.MarcaDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.ListaModelosEAnosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "dadosFipe", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")
public interface ListarDadosFipe {

    @RequestMapping(method = RequestMethod.GET)
    List<MarcaDTO> listarMarcas();

    @RequestMapping(method = RequestMethod.GET,value ="/{idMarca}/modelos")
    ListaModelosEAnosDTO listarModelosPorMarca(@PathVariable("idMarca") String idMarca);

    @RequestMapping(method = RequestMethod.GET,value ="/{idMarca}/modelos/{idModelo}/anos")
    List<AnoDTO> listarVeiculosPorAnosPorModeloEMarca(@RequestBody @PathVariable("idMarca") String id,
                                                      @PathVariable("idModelo") String idModelo);

    @RequestMapping(method = RequestMethod.GET,value ="/{idMarca}/modelos/{idModelo}/anos/{idAno}")
    String listarVeiculoCompleto(@RequestBody @PathVariable("idMarca") String id,
                                @PathVariable("idModelo") String idModelo,
                                @PathVariable("idAno")String idAno);

}
