package clases;

public class Vehiculo {

   private Integer velocidad;
   private Integer aceleracion;
   private Integer anguloDeGiro;
   private String patente;
   private Integer peso;
   private Integer ruedas;

   public Integer getVelocidad() {
      return velocidad;
   }

   public void setVelocidad(Integer velocidad) {
      this.velocidad = velocidad;
   }

   public Integer getAceleracion() {
      return aceleracion;
   }

   public void setAceleracion(Integer aceleracion) {
      this.aceleracion = aceleracion;
   }

   public Integer getAnguloDeGiro() {
      return anguloDeGiro;
   }

   public void setAnguloDeGiro(Integer anguloDeGiro) {
      this.anguloDeGiro = anguloDeGiro;
   }

   public String getPatente() {
      return patente;
   }

   public void setPatente(String patente) {
      this.patente = patente;
   }

   public Integer getPeso() {
      return peso;
   }

   public void setPeso(Integer peso) {
      this.peso = peso;
   }

   public Integer getRuedas() {
      return ruedas;
   }

   public void setRuedas(Integer ruedas) {
      this.ruedas = ruedas;
   }

   public Vehiculo(){

   }

   public Vehiculo(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
      this.velocidad = velocidad;
      this.aceleracion = aceleracion;
      this.anguloDeGiro = anguloDeGiro;
      this.patente = patente;
   }

   @Override
   public String toString() {
      return "Vehiculo [aceleracion=" + aceleracion + ", anguloDeGiro=" + anguloDeGiro + ", patente=" + patente
            + ", peso=" + peso + ", ruedas=" + ruedas + ", velocidad=" + velocidad + "]";
   }
}
