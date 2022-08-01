public class Cliente {

    private String name;
    private String lastName;
    private String cellphone;
    private String dni;
    private String mail;

    public Cliente(String name, String lastName, String cellphone, String dni, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.dni = dni;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

//    //public boolean equal(){
//        return true;
//    }

    @Override
    public String toString() {
        return "** Cliente: \n" +
                "name= " + name + "\n" +
                "lastName= " + lastName + "\n" +
                "cellphone= " + cellphone + "\n" +
                "dni= " + dni + "\n" +
                "mail= " + mail + "\n";
    }
}
