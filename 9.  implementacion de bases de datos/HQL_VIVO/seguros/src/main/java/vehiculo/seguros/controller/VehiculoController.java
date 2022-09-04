package vehiculo.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vehiculo.seguros.dto.VehiculoSiniestro;
import vehiculo.seguros.dto.Vehiculo_Marca_ModeloDTO;
import vehiculo.seguros.dto.Vehiculo_PatenteDTO;
import vehiculo.seguros.dto.Vehiculo_Patente_MarcaDTO;
import vehiculo.seguros.service.IVehiculoService;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService iVehiculoService;

    @GetMapping("/patentes")
    public List<Vehiculo_PatenteDTO> getPatentesVehiculos(){
        return iVehiculoService.getListPatentesVehiculos();
    }

    @GetMapping("/patentes_marcas")
    public List<Vehiculo_Patente_MarcaDTO> getPatentesMarcaOrderByFabricacionVehiculos(){
        return iVehiculoService.getPatentesMarcaOrderByFabricacionVehiculos();
    }

    @GetMapping("/vehiculos_grandes")
    public List<Vehiculo_PatenteDTO> getPatentesMasCuatroRuedas(){
        return iVehiculoService.getPatentesMasCuatroRuedas();
    }

    @GetMapping("/siniestros")
    public List<Vehiculo_Marca_ModeloDTO> getVehiculosGrandesSiniestros(){
        return iVehiculoService.getVehiculosGrandesSiniestros();
    }

    @GetMapping("/siniestros_total")
    public VehiculoSiniestro getVehiculosTotalGrandesSiniestros(){
        return iVehiculoService.getVehiculosTotalGrandesSiniestros();
    }
}
