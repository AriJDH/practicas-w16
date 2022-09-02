package com.compositekey.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseId implements Serializable {

    private Integer clientId;

    private LocalDate datePurchase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseId that = (PurchaseId) o;
        return clientId.equals(that.clientId) && datePurchase.equals(that.datePurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, datePurchase);
    }

}
