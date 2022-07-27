abstract class Person {

    private String name;
    private String lastName;
    private String dni;
    private int age;
    private String celPhone;
    private String emergencyNumber;
    private String bloodyType;
    private static int id;
    private static int lastId = 0;

    public abstract double CalculateSubscription();

    public boolean validateFields() {
        return name != null && !name.isEmpty() && lastName != null && !lastName.isEmpty() && dni != null && !dni.isEmpty() && age > 0 &&
                celPhone != null && !celPhone.isEmpty() && emergencyNumber != null && !emergencyNumber.isEmpty() && bloodyType != null && !bloodyType.isEmpty();
    }


    public void setSubscriptionID() {

        id = lastId++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", celPhone='" + celPhone + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", bloodyType='" + bloodyType + '\'' +
                '}';
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = celPhone;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodyType() {
        return bloodyType;
    }

    public void setBloodyType(String bloodyType) {
        this.bloodyType = bloodyType;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Person.id = id;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Person.lastId = lastId;
    }
}
