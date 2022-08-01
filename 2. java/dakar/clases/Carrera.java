package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

   private Integer distancia;
   private Integer premioEnDolares;
   private String nombre;
   private Integer cantidadDeVehiculosPermitidos;
   private List<Vehiculo> listaDeVehiculos;
   private SocorristaAuto socorristaAuto;
   private SocorristaMoto socorristaMoto;

   public Integer getDistancia() {
      return distancia;
   }

   public SocorristaMoto getSocorristaMoto() {
      return socorristaMoto;
   }

   public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
      this.socorristaMoto = socorristaMoto;
   }

   public SocorristaAuto getSocorristaAuto() {
      return socorristaAuto;
   }

   public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
      this.socorristaAuto = socorristaAuto;
   }

   public void setDistancia(Integer distancia) {
      this.distancia = distancia;
   }

   public Integer getPremioEnDolares() {
      return premioEnDolares;
   }

   public void setPremioEnDolares(Integer premioEnDolares) {
      this.premioEnDolares = premioEnDolares;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Integer getCantidadDeVehiculosPermitidos() {
      return cantidadDeVehiculosPermitidos;
   }

   public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
      this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
   }

   public List<Vehiculo> getListaDeVehiculos() {
      return listaDeVehiculos;
   }

   public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
      this.listaDeVehiculos = listaDeVehiculos;
   }

   public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
      this.distancia = distancia;
      this.premioEnDolares = premioEnDolares;
      this.nombre = nombre;
      this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
      this.listaDeVehiculos = new ArrayList<>();
   }

   public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
      if (this.cantidadDeVehiculosPermitidos > this.listaDeVehiculos.size()) {
         Vehiculo auto = new Autos(velocidad, aceleracion, anguloDeGiro, patente);
         listaDeVehiculos.add(auto);
         System.out.println("El auto " + patente + " fue resgistrado con exito.");
      } else {
         System.out.println("No hay mas cupos libres.");
      }
   }

   public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
      if (this.cantidadDeVehiculosPermitidos > this.listaDeVehiculos.size()) {
         Vehiculo moto = new Motos(velocidad, aceleracion, anguloDeGiro, patente);
         listaDeVehiculos.add(moto);
         System.out.println("La moto " + patente + " fue resgistrada con exito.");
      } else {
         System.out.println("No hay mas cupos libres.");
      }
   }

   public void eliminarVehiculo(Vehiculo vehiculo) {
      this.listaDeVehiculos = this.listaDeVehiculos.stream()
            .filter(x -> !x.equals(vehiculo)).collect(Collectors.toList());
   }

   public void eliminarVehiculoConPatente(String patente) {
      this.listaDeVehiculos = this.listaDeVehiculos.stream()
            .filter(x -> !x.getPatente().equals(patente)).collect(Collectors.toList());
   }

   public Vehiculo definirGanador() {
      Integer valor = 0;
      Integer indice = 0;

      for (int i = 0; i < listaDeVehiculos.size(); i++) {
         if (formulaGanador(listaDeVehiculos.get(i)) > valor) {
            valor = formulaGanador(listaDeVehiculos.get(i));
            indice = i;
         }
      }
      return listaDeVehiculos.get(indice);
   }

   public Integer formulaGanador(Vehiculo vehiculo) {
      return (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2))
            / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
   }

   public void SocorrerAuto(String patente) {
      Vehiculo vehiculo = this.listaDeVehiculos.stream()
            .filter(x -> x.getPatente().equals(patente)).findFirst().get();
      socorristaAuto.socorrer(vehiculo);
   }

   public void SocorrerMoto(String patente) {
      Vehiculo vehiculo = this.listaDeVehiculos.stream()
            .filter(x -> x.getPatente().equals(patente)).findFirst().get();
      socorristaMoto.socorrer(vehiculo);
   }

   @Override
   public String toString() {
      return "Carrera [cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos + ", distancia=" + distancia
            + ", listaDeVehiculos=" + listaDeVehiculos + ", nombre=" + nombre + ", premioEnDolares="
            + premioEnDolares + "]";
   }

}
