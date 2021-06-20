package com.desafio.controledeveiculos.controleveiculos.service;

import com.desafio.controledeveiculos.controleveiculos.consumoapifipe.ListarDadosFipe;
import com.desafio.controledeveiculos.controleveiculos.dto.*;
import com.desafio.controledeveiculos.controleveiculos.model.Usuario;
import com.desafio.controledeveiculos.controleveiculos.model.Veiculo;
import com.desafio.controledeveiculos.controleveiculos.repository.UsuarioRepository;
import com.desafio.controledeveiculos.controleveiculos.repository.VeiculoRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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

    public void salvar(VeiculoDTO veiculoDTO){
        Veiculo veiculo = new Veiculo();
        String valor = retornarValorVeiculoFipe(veiculoDTO);

        System.out.println(veiculoDTO);
        System.out.println(valor);

        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setModeloVeiculo(veiculoDTO.getModeloVeiculo());
        veiculo.setAnoVeiculo(veiculoDTO.getAnoVeiculo());
        veiculo.setValor(valor);

        Long idUsuario = veiculoDTO.getIdUsuario();

        if(idUsuario != null) {
            Optional<Usuario> usuario = usuarioRepository.findById(veiculoDTO.getIdUsuario());

            if (usuario.isPresent()) {
                veiculo.setUsuario(usuario.get());
            }
        }

        veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    private String retornarValorVeiculoFipe(VeiculoDTO veiculoDTO){
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
        List<AnoDTO> anosPorModeloEMarca = listarDadosFipe.listarModelosPorMarca(idMarca).getAnos();

        Optional<ModeloDTO> modeloPorMarca = modelosPorMarca
                .stream()
                .filter(m -> m.getNome().equalsIgnoreCase(veiculoDTO.getModeloVeiculo()))
                .findFirst();

        idModelo = Integer.toString(modeloPorMarca.get().getCodigo());

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
}
