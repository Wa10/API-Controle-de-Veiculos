package com.desafio.controledeveiculos.controleveiculos.service;

import com.desafio.controledeveiculos.controleveiculos.consumoapifipe.ListarDadosFipe;
import com.desafio.controledeveiculos.controleveiculos.dto.*;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.AnoDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.DadosCompletosComValorDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.MarcaDTO;
import com.desafio.controledeveiculos.controleveiculos.dto.fipe.ModeloDTO;
import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import com.desafio.controledeveiculos.controleveiculos.repository.UsuarioRepository;
import com.desafio.controledeveiculos.controleveiculos.repository.VeiculoRepository;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ListarDadosFipe listarDadosFipe;
    private final UsuarioRepository usuarioRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ListarDadosFipe listarDadosFipe, UsuarioRepository usuarioRepository) {
        this.veiculoRepository = veiculoRepository;
        this.listarDadosFipe = listarDadosFipe;
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        String valor = retornarValorVeiculoFipe(veiculoDTO);
        String diaSemana = diaDoRodizio(veiculoDTO.getAnoVeiculo());

        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setModeloVeiculo(veiculoDTO.getModeloVeiculo());
        veiculo.setAnoVeiculo(veiculoDTO.getAnoVeiculo());
        veiculo.setValor(valor);
        veiculo.setDiaRodizio(diaSemana);

        Long idUsuario = veiculoDTO.getIdUsuario();



        if(idUsuario != null){
            Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
            if(usuario.isPresent()) {
                veiculo.setIdUsuario(idUsuario);
            } else{
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario não cadastrado"
                );
            }
        }

        veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    private String retornarValorVeiculoFipe(VeiculoDTO veiculoDTO) {
        String idMarca = "";
        String idModelo = "";
        String idAno = "";

        List<MarcaDTO> marcas = listarDadosFipe.listarMarcas();

        Optional<MarcaDTO> marca = marcas
                .stream()
                .filter(m -> m.getNome().equalsIgnoreCase(veiculoDTO.getMarca()))
                .findFirst();

        idMarca = marca.get().getCodigo();

        List<ModeloDTO> modelosPorMarca = listarDadosFipe.listarModelosPorMarca(idMarca).getModelos();


        Optional<ModeloDTO> modeloPorMarca = modelosPorMarca
                .stream()
                .filter(m -> m.getNome().equalsIgnoreCase(veiculoDTO.getModeloVeiculo()))
                .findFirst();

        idModelo = Integer.toString(modeloPorMarca.get().getCodigo());

        List<AnoDTO> anosPorModeloEMarca = listarDadosFipe.listarVeiculosPorAnosPorModeloEMarca(idMarca, idModelo);

        Optional<AnoDTO> anoPorModeloEMarca = anosPorModeloEMarca
                .stream()
                .filter(a -> a.getNome().equalsIgnoreCase(veiculoDTO.getAnoVeiculo()))
                .findFirst();

        idAno = anoPorModeloEMarca.get().getCodigo();

        String dadosEmJson = listarDadosFipe.listarVeiculoCompleto(idMarca, idModelo, idAno);

        Gson conversorJson = new Gson();
        DadosCompletosComValorDTO dadoCompleto = conversorJson.fromJson(dadosEmJson, DadosCompletosComValorDTO.class);

        return dadoCompleto.getValor();
    }

    private String diaDoRodizio(String ano) {
        Character ultimoNumeroAno = ano.charAt(3);


        if (ultimoNumeroAno.equals('0') || ultimoNumeroAno.equals('1')) {
            return "segunda-feira";
        } else if (ultimoNumeroAno.equals('2') || ultimoNumeroAno.equals('3')) {
            return "terça-feira";
        } else if (ultimoNumeroAno.equals("4") || ultimoNumeroAno.equals('5')) {
            return "quarta-feira";
        } else if (ultimoNumeroAno.equals("6") || ultimoNumeroAno.equals("7")) {
            return "quinta-feira";
        } else {
            return "sexta-feira";
        }
    }


    public List<Veiculo> listarVeiculosPorUsuario(Long id){
        return veiculoRepository.listarVeiculosPorUsuario(id);
    }
}
