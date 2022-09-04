package vehiculo.seguros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehiculo.seguros.dto.Vehiculo_Marca_ModeloDTO;
import vehiculo.seguros.dto.Vehiculo_PatenteDTO;
import vehiculo.seguros.dto.Vehiculo_Patente_MarcaDTO;
import vehiculo.seguros.model.Vehiculo;
import vehiculo.seguros.dto.VehiculoSiniestro;
import vehiculo.seguros.repository.IVehiculoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoRepository iVehiculoRepository;

    @Override
    public List<Vehiculo_PatenteDTO> getListPatentesVehiculos() {
        List<String> vehiculos = iVehiculoRepository.getListPatenteVehiculo();
        List<Vehiculo_PatenteDTO> patentes = new ArrayList<>();

        for(String v: vehiculos){
            patentes.add(new Vehiculo_PatenteDTO(v));
        }
        return patentes;
    }

    @Override
    public List<Vehiculo_Patente_MarcaDTO> getPatentesMarcaOrderByFabricacionVehiculos() {
        List<Vehiculo> vehiculos = iVehiculoRepository.getListPatenteMarcaOrderByFabricacionVehiculo();
        List<Vehiculo_Patente_MarcaDTO> patentes_marca = new ArrayList<>();

        for(Vehiculo v: vehiculos){
            patentes_marca.add(new Vehiculo_Patente_MarcaDTO(v.getPatente(),v.getMarca()));
        }

        return patentes_marca;
    }

    @Override
    public List<Vehiculo_PatenteDTO> getPatentesMasCuatroRuedas() {
        List<String> vehiculos = iVehiculoRepository.getPatentesMasCuatroRuedas(LocalDate.now().getYear());
        List<Vehiculo_PatenteDTO> patentes = new ArrayList<>();

        for(String v: vehiculos){
            patentes.add(new Vehiculo_PatenteDTO(v));
        }
        return patentes;
    }

    @Override
    public List<Vehiculo_Marca_ModeloDTO> getVehiculosGrandesSiniestros() {
        List<Vehiculo> vehiculos = iVehiculoRepository.getVehiculosGrandesSiniestros();
        List<Vehiculo_Marca_ModeloDTO> patentes_marca = new ArrayList<>();

        for(Vehiculo v: vehiculos){
            patentes_marca.add(new Vehiculo_Marca_ModeloDTO(v.getPatente(),v.getMarca(), v.getModelo()));
        }

        return patentes_marca;
    }

    @Override
    public VehiculoSiniestro getVehiculosTotalGrandesSiniestros() {
        Integer perdidaTotal = iVehiculoRepository.gePerdidaTotal();
        List<Vehiculo> vehiculos = iVehiculoRepository.getVehiculosGrandesSiniestros();
        List<Vehiculo_Marca_ModeloDTO> patentes_marca = new ArrayList<>();

        for(Vehiculo v: vehiculos){
            patentes_marca.add(new Vehiculo_Marca_ModeloDTO(v.getPatente(),v.getMarca(), v.getModelo()));
        }
        VehiculoSiniestro siniestrosTotales = new VehiculoSiniestro(patentes_marca,perdidaTotal);
        return siniestrosTotales;
    }
}
