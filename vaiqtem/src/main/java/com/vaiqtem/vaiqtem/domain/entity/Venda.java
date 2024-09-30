package com.vaiqtem.vaiqtem.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(name = "data_venda", nullable = false) // Nome da coluna e não nula
    private LocalDateTime dataVenda;

    @Column(nullable = false) // Quantidade não pode ser nula
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false) // Nome da coluna e não nula
    private Double valorTotal;

    @ManyToOne // Relacionamento com a entidade Peca
    @JoinColumn(name = "peca_id", nullable = false) // Coluna de chave estrangeira
    private Peca peca;


}
