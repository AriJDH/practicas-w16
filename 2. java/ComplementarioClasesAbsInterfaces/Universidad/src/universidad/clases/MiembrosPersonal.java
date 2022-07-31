package universidad.clases;

import universidad.interfaces.PersonalUniversidad;

public class MiembrosPersonal implements PersonalUniversidad {

    @Override
    public void cargo() {
        System.out.println("Soy un miembro de la universidad");
    }
}
