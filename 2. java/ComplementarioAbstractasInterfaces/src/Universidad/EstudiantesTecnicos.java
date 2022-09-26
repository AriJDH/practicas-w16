package Universidad;

import Universidad.interfaces.IPersonalUniversidad;
import Universidad.interfaces.ISoporte;

public class EstudiantesTecnicos extends Estudiantes implements IPersonalUniversidad, ISoporte {

  @Override
  public void cargo() {
    System.out.println("Soy estudiante técnico");
  }

  @Override
  public void soporteTecnico() {
    System.out.println("Soy un estudiante que realiza soporte técnico");
  }
}
