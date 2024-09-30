package com.vaiqtem.vaiqtem.service;

import com.vaiqtem.vaiqtem.Exception.ConsignadoNotFoundException;
import com.vaiqtem.vaiqtem.domain.entity.Consignado;
import com.vaiqtem.vaiqtem.domain.entity.Peca;
import com.vaiqtem.vaiqtem.repository.ConsignadoRepository;
import com.vaiqtem.vaiqtem.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaiqtem.vaiqtem.dto.PecaDTO;

import java.util.List;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    @Autowired
    private ConsignadoRepository consignadoRepository;

    public PecaDTO salvarPeca(PecaDTO pecaDTO) {
        // Verifica se o consignado já existe
        Consignado consignado = consignadoRepository.findById(pecaDTO.getConsignadoId())
                .orElseThrow(() -> new ConsignadoNotFoundException("Consignado não encontrado"));

        // Converte o DTO em entidade Peca
        Peca peca = pecaDTO.toEntity();
        peca.setConsignado(consignado); // Define o consignado existente na peça

        // Salva a peça no banco de dados
        Peca novaPeca = pecaRepository.save(peca);

        // Retorna o DTO convertido da entidade Peca salva
        return PecaDTO.fromEntity(novaPeca);
    }

    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    public List<Peca> listarPorCondicao(String condicao) {
        return pecaRepository.findByCondicao(condicao);
    }
}
