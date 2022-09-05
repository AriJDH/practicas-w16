package com.compound.compoundbuy.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PucharseKey implements Serializable {

    private Integer clientId;
    private LocalDate date_pucharse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PucharseKey that = (PucharseKey) o;
        return clientId.equals(that.clientId) && date_pucharse.equals(that.date_pucharse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, date_pucharse);
    }
}
