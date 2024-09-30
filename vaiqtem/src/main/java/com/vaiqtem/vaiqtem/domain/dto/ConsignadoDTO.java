package com.vaiqtem.vaiqtem.domain.dto;

import com.vaiqtem.vaiqtem.domain.entity.Consignado;
import com.vaiqtem.vaiqtem.domain.entity.Peca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignadoDTO {
    private Long id; // ID do consignado
    private String cpf;
    private String email;
    private String nome;
    private String telefone;


    // Método para converter de DTO para Entidade
    public Consignado toEntity() {
        return Consignado.builder()
                .id(this.id)
                .cpf(this.cpf)
                .email(this.email)
                .nome(this.nome)
                .telefone(this.telefone)
                .build();
    }

    // Método para converter de Entidade para DTO
    public static ConsignadoDTO fromEntity(Consignado consignado) {
        return ConsignadoDTO.builder()
                .id(consignado.getId())
                .cpf(consignado.getCpf())
                .email(consignado.getEmail())
                .nome(consignado.getNome())
                .telefone(consignado.getTelefone())
                .build();
    }
}
