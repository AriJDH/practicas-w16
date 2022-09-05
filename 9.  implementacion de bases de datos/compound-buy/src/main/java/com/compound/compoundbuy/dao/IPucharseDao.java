package com.compound.compoundbuy.dao;

import com.compound.compoundbuy.entity.Pucharse;
import com.compound.compoundbuy.entity.PucharseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPucharseDao extends JpaRepository<Pucharse, PucharseKey> {
}
