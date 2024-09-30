package com.vaiqtem.vaiqtem.controller;


import com.vaiqtem.vaiqtem.domain.entity.Peca;
import com.vaiqtem.vaiqtem.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vaiqtem.vaiqtem.dto.PecaDTO;

import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    @PostMapping
    public ResponseEntity<PecaDTO> criarPeca(@RequestBody PecaDTO pecaDTO) {
        // Chamar o serviço para salvar a peça
        PecaDTO novaPecaDTO = pecaService.salvarPeca(pecaDTO);
        // Retornar a nova peça criada
        return ResponseEntity.ok(novaPecaDTO);
    }

    @GetMapping
    public List<Peca> listarPecas() {
        return pecaService.listarTodas();
    }

    @GetMapping("/condicao/{condicao}")
    public List<Peca> listarPorCondicao(@PathVariable String condicao) {
        return pecaService.listarPorCondicao(condicao);
    }
}
