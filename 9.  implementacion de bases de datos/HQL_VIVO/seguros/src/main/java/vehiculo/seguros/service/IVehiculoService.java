package vehiculo.seguros.service;

import vehiculo.seguros.dto.VehiculoSiniestro;
import vehiculo.seguros.dto.Vehiculo_Marca_ModeloDTO;
import vehiculo.seguros.dto.Vehiculo_PatenteDTO;
import vehiculo.seguros.dto.Vehiculo_Patente_MarcaDTO;

import java.util.List;

public interface IVehiculoService{
    public List<Vehiculo_PatenteDTO> getListPatentesVehiculos();
    public List<Vehiculo_Patente_MarcaDTO> getPatentesMarcaOrderByFabricacionVehiculos();
    public List<Vehiculo_PatenteDTO> getPatentesMasCuatroRuedas();
    public List<Vehiculo_Marca_ModeloDTO> getVehiculosGrandesSiniestros();
    public VehiculoSiniestro getVehiculosTotalGrandesSiniestros();
}
