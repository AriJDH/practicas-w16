package Universidad;

import Universidad.interfaces.IPersonalUniversidad;

public class PersonalMantenimiento implements IPersonalUniversidad {

  @Override
  public void cargo() {
    System.out.println("Soy del personal de mantenimiento");
  }
}
