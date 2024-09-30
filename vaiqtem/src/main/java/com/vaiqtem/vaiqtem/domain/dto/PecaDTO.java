package com.vaiqtem.vaiqtem.dto;

import com.vaiqtem.vaiqtem.domain.entity.Peca;
import com.vaiqtem.vaiqtem.domain.entity.Consignado; // Adicione este import se necessário
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PecaDTO {
    private Long id; // ID da peça
    private String condicao;
    private String cor;
    private Integer estoque;
    private String marca;
    private String nome;
    private Double preco;
    private String tamanho;
    private String tipo;
    private Long consignadoId; // ID do consignado associado

    // Método para converter de DTO para Entidade
    public Peca toEntity() {
        return Peca.builder()
                .id(this.id)
                .condicao(this.condicao)
                .cor(this.cor)
                .estoque(this.estoque)
                .marca(this.marca)
                .nome(this.nome)
                .preco(this.preco)
                .tamanho(this.tamanho)
                .tipo(this.tipo)
                .consignado(new Consignado(this.consignadoId)) // Assumindo que Consignado tem um construtor que aceita ID
                .build();
    }

    // Método para converter de Entidade para DTO
    public static PecaDTO fromEntity(Peca peca) {
        return PecaDTO.builder()
                .id(peca.getId())
                .condicao(peca.getCondicao())
                .cor(peca.getCor())
                .estoque(peca.getEstoque())
                .marca(peca.getMarca())
                .nome(peca.getNome())
                .preco(peca.getPreco())
                .tamanho(peca.getTamanho())
                .tipo(peca.getTipo())
                .consignadoId(peca.getConsignado() != null ? peca.getConsignado().getId() : null) // Verifica se consignado não é nulo
                .build();
    }
}
