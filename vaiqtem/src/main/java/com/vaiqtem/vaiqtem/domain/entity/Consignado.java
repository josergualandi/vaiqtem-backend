package com.vaiqtem.vaiqtem.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consignado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(nullable = false, unique = true) // CPF não pode ser nulo e deve ser único
    private String cpf;

    @Column(nullable = false, unique = true) // Email não pode ser nulo e deve ser único
    private String email;

    @Column(nullable = false) // Nome não pode ser nulo
    private String nome;

    @Column(nullable = false) // Telefone não pode ser nulo
    private String telefone;

    public Consignado(Long consignadoId) {
    }
}

