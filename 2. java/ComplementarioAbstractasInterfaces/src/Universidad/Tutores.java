package Universidad;

import Universidad.interfaces.IEducacion;
import Universidad.interfaces.IPersonalUniversidad;

public class Tutores extends Estudiantes implements IPersonalUniversidad, IEducacion {

  @Override
  public void cargo() {
    System.out.println("Soy un tutor");
  }

  @Override
  public void educar() {
    System.out.println("Soy un estudiante que tengo la labor complementaria de enseñar");
  }
}