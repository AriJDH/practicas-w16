package com.bootcamp.lasperlas.service;

import com.bootcamp.lasperlas.dto.request.JoyaDTO;
import com.bootcamp.lasperlas.dto.request.JoyaUpdateDTO;
import com.bootcamp.lasperlas.dto.response.JoyaIdentidicadorDTO;
import com.bootcamp.lasperlas.model.Joya;
import com.bootcamp.lasperlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService  implements IJoyaService {

  final ModelMapper modelMapper;


  public JoyaService() {
    this.modelMapper = new ModelMapper();
  }

  @Autowired
  IJoyaRepository iJoyaRepository;



  @Override
  public JoyaIdentidicadorDTO crearJoya(JoyaDTO joyaDto) {
    Joya joya = modelMapper.map(joyaDto, Joya.class);
    iJoyaRepository.save(joya);
    return new JoyaIdentidicadorDTO(joya.getNroIdentificatorio());
  }


  @Override
  public List<JoyaDTO> listadoJoya() {


    return  iJoyaRepository.findAll()
            .stream()
            .filter(Joya::getVenta)
            .map(x -> modelMapper.map(x, JoyaDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public void eliminar(Long id) {
    // Joya joya = modelMapper.map(joyaDto, Joya.class);
    Joya joyaEliminar = iJoyaRepository.findById(id).orElse(null);
    joyaEliminar.setVenta(false);
    iJoyaRepository.save(joyaEliminar);

  }

  @Override
  public JoyaUpdateDTO editarJoya(JoyaUpdateDTO joyaDTO, Long id) {
    Joya joyaEditar = iJoyaRepository.findById(id).orElse(null);

    joyaEditar.setNombre(joyaDTO.getNombre());
    joyaEditar.setMaterial(joyaDTO.getMaterial());
    joyaEditar.setPeso(joyaDTO.getPeso());
    joyaEditar.setParticularidad(joyaDTO.getParticularidad());
    joyaEditar.setPoseePiedra(joyaDTO.getPoseePiedra());
    joyaEditar.setVenta(joyaDTO.getVenta());

    //todo devuelve un objeto Joya
    Joya joya = iJoyaRepository.save(joyaEditar);

    return modelMapper.map(joya, JoyaUpdateDTO.class);
  }

}
