package com.meli.clavecompuestas.repository;

import com.meli.clavecompuestas.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<CompraKey, Long> {
}
