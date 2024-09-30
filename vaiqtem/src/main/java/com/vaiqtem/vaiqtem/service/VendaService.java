package com.vaiqtem.vaiqtem.service;

import com.vaiqtem.vaiqtem.domain.entity.Peca;
import com.vaiqtem.vaiqtem.domain.entity.Venda;
import com.vaiqtem.vaiqtem.repository.PecaRepository;
import com.vaiqtem.vaiqtem.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PecaRepository pecaRepository;

    public Venda registrarVenda(Long pecaId, Integer quantidade) {
        Peca peca = pecaRepository.findById(pecaId).orElseThrow(() -> new RuntimeException("Peça não encontrada"));

        if (peca.getEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        Venda venda = new Venda();
        venda.setPeca(peca);
        venda.setQuantidade(quantidade);
        venda.setDataVenda(LocalDateTime.now());
        venda.setValorTotal(peca.getPreco() * quantidade);

        peca.setEstoque(peca.getEstoque() - quantidade);  // Atualizar o estoque
        pecaRepository.save(peca);

        return vendaRepository.save(venda);
    }
}
