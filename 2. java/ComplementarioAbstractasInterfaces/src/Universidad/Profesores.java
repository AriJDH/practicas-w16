package Universidad;

import Universidad.interfaces.IEducacion;
import Universidad.interfaces.IPersonalUniversidad;

public class Profesores implements IPersonalUniversidad, IEducacion {

  @Override
  public void cargo() {
    System.out.println("Soy profesor");
  }

  @Override
  public void educar() {
    System.out.println("Soy un profesor y tengo la labor de enseñar");
  }
}
