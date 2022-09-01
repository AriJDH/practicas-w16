package com.bootcamp.compoundkey.repository;

import com.bootcamp.compoundkey.model.Compra;
import com.bootcamp.compoundkey.model.CompraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraId> {
}
