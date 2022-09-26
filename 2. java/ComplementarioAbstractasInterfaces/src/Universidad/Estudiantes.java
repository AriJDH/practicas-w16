package Universidad;

import Universidad.interfaces.IPersonalUniversidad;

public class Estudiantes implements IPersonalUniversidad {

  @Override
  public void cargo() {
    System.out.println("Soy estudiante");
  }
}
