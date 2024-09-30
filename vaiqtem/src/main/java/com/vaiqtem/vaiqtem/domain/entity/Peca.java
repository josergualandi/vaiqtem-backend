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

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
 public class Peca {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
   private Long id;

  @Column(nullable = false) // Condição não pode ser nula
  private String condicao;

  @Column(nullable = false) // Cor não pode ser nula
  private String cor;

  @Column(nullable = false) // Estoque não pode ser nulo
  private Integer estoque;

  @Column(nullable = false) // Marca não pode ser nula
  private String marca;

  @Column(nullable = false) // Nome não pode ser nulo
  private String nome;

  @Column(nullable = false) // Preço não pode ser nulo
  private Double preco;

  @Column(nullable = false) // Tamanho não pode ser nulo
  private String tamanho;

  @Column(nullable = false) // Tipo não pode ser nulo
  private String tipo;

  @ManyToOne // Relacionamento com a entidade Consignado
  @JoinColumn(name = "consignado_id", nullable = false) // Coluna de chave estrangeira
  private Consignado consignado;


}
