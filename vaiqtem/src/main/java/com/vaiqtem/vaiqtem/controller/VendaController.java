package com.vaiqtem.vaiqtem.controller;

import com.vaiqtem.vaiqtem.domain.entity.Venda;
import com.vaiqtem.vaiqtem.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> realizarVenda(@RequestParam Long pecaId, @RequestParam Integer quantidade) {
        Venda venda = vendaService.registrarVenda(pecaId, quantidade);
        return ResponseEntity.ok(venda);
    }
}
