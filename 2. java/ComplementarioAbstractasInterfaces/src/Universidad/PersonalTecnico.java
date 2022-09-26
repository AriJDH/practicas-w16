package Universidad;

import Universidad.interfaces.IPersonalUniversidad;
import Universidad.interfaces.ISoporte;

public class PersonalTecnico implements IPersonalUniversidad, ISoporte {

  @Override
  public void cargo() {
    System.out.println("Soy del personal técnico");
  }

  @Override
  public void soporteTecnico() {
    System.out.println("Soy personal que realiza soporte técnico");
  }
}
