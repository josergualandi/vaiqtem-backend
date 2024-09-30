package com.vaiqtem.vaiqtem.domain.dto;

import com.vaiqtem.vaiqtem.domain.entity.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {
    private Long id; // ID da venda
    private LocalDateTime dataVenda; // Data da venda
    private Integer quantidade; // Quantidade vendida
    private Double valorTotal; // Valor total da venda
    private Long pecaId; // ID da peça associada

    // Método para converter de DTO para Entidade
    public Venda toEntity() {
        return Venda.builder()
                .id(this.id)
                .dataVenda(this.dataVenda)
                .quantidade(this.quantidade)
                .valorTotal(this.valorTotal)
                .build();
    }

    // Método para converter de Entidade para DTO
    public static VendaDTO fromEntity(Venda venda) {
        return VendaDTO.builder()
                .id(venda.getId())
                .dataVenda(venda.getDataVenda())
                .quantidade(venda.getQuantidade())
                .valorTotal(venda.getValorTotal())
                .pecaId(venda.getPeca() != null ? venda.getPeca().getId() : null) // Mapeia ID da peça
                .build();
    }
}
