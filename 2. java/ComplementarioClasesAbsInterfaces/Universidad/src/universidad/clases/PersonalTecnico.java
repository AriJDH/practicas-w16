package universidad.clases;

import universidad.interfaces.PersonalUniversidad;
import universidad.interfaces.Soporte;

public class PersonalTecnico implements PersonalUniversidad, Soporte {

    @Override
    public void cargo() {
        System.out.println("Soy parte del personal técnico");
    }


    @Override
    public void soporteTecnico() {
        System.out.println("Soy personal que realiza soporte técnico");
    }
}
