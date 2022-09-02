package com.compositekey.purchase.dao;

import com.compositekey.purchase.entity.Purchase;
import com.compositekey.purchase.entity.PurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseDao extends JpaRepository<Purchase, PurchaseId> {
}
