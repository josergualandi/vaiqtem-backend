package com.vaiqtem.vaiqtem.repository;

import com.vaiqtem.vaiqtem.domain.entity.Consignado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsignadoRepository extends JpaRepository<Consignado, Long> {
}
