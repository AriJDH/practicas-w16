package roa.ejemplo.estoessolounejemplo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name="person")
@IdClass(value = PersonKey.class)
public class Person {
  @Id
  private Integer dni;
  @Id
  private Integer numTramite;

}
