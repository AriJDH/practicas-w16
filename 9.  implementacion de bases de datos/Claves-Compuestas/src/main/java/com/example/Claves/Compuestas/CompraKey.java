package com.example.Claves.Compuestas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class CompraKey implements Serializable {

    private Long clienteId;
    private Date fecha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(clienteId, compraKey.clienteId) && Objects.equals(fecha, compraKey.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, fecha);
    }
}
