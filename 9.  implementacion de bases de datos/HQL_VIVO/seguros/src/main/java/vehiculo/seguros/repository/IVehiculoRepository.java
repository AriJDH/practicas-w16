package vehiculo.seguros.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vehiculo.seguros.model.Vehiculo;
import vehiculo.seguros.dto.VehiculoSiniestro;

import java.util.List;

public interface IVehiculoRepository extends CrudRepository<Vehiculo,Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getListPatenteVehiculo();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.year_fabricacion")
    List<Vehiculo> getListPatenteMarcaOrderByFabricacionVehiculo();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.ruedas>4 AND v.year_fabricacion = :current_year")
    List<String> getPatentesMasCuatroRuedas(Integer current_year);

    @Query("SELECT v FROM Vehiculo v INNER JOIN v.siniestro s WHERE s.perdida_economica>10000")
    List<Vehiculo> getVehiculosGrandesSiniestros();

    @Query("SELECT  SUM(s.perdida_economica) AS perdida FROM Vehiculo v INNER JOIN v.siniestro s WHERE s.perdida_economica>10000")
    Integer gePerdidaTotal();
}
