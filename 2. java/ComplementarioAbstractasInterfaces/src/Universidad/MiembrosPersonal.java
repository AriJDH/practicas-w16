package Universidad;

import Universidad.interfaces.IPersonalUniversidad;

public class MiembrosPersonal implements IPersonalUniversidad {

  @Override
  public void cargo() {
    System.out.println("Soy un miembro de la universidad");
  }
}
