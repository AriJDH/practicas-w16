package roa.ejemplo.estoessolounejemplo.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
public class PersonKey implements Serializable {
  private Integer dni;
  private Integer numTramite;

  @Override
  public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonKey that = (PersonKey) o;
    return Objects.equals(dni, that.dni) && Objects.equals(numTramite, that.numTramite);
  }


  @Override
  public int hashCode() {return Objects.hash(dni, numTramite);}
}
