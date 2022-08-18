public class Vehicle {
    private Double speed;
    private Double acceleration;
    private Double turningAngle;
    private String patent;
    private Double weight;
    private Integer wheel;

    private Double calculation;

    public Vehicle(Double speed, Double acceleration, Double turningAngle, String patent, Double weight, Integer wheel) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.patent = patent;
        this.weight = weight;
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Aceleracion: " + acceleration +
                ", Velocidad: " + speed +
                ", Angulo de giro: " + turningAngle +
                ", Patente: '" + patent + '\'' +
                ", Peso: " + weight +
                ", Ruedas: " + wheel;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Double getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(Double turningAngle) {
        this.turningAngle = turningAngle;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWheel() {
        return wheel;
    }

    public void setWheel(Integer wheel) {
        this.wheel = wheel;
    }

    public Double getCalculation() {
        return calculation;
    }

    public void setCalculation(Double calculation) {
        this.calculation = calculation;
    }
}
