package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JoyaDTO;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaService {

  @Autowired
  private JoyaRepository joyaRepository;

  public Integer saveJewerly(JoyaDTO joyaDTO) {
    Joya joya = joyaRepository.save(new Joya(joyaDTO.getNombre(), joyaDTO.getMaterial(),
        joyaDTO.getPeso(), joyaDTO.getParticularidad(), joyaDTO.getPoseePiedra()));
    return joya.getNumeroIdentificatorio();
  }

  public List<JoyaDTO> findAll() {
    return joyaRepository.findAll().stream()
        .map(this::mapToJoyaDto)
        .collect(Collectors.toList());
  }

  public void deleteById(Integer id) {
    Optional<Joya> joya = joyaRepository.findById(id);
    if (joya.isEmpty()) throw new RuntimeException("No existe");
    joyaRepository.delete(joya.get());
  }

  public JoyaDTO updateById(Integer id, JoyaDTO joyaDTO) {
    Optional<Joya> joya = joyaRepository.findById(id);
    if (joya.isEmpty()) throw new RuntimeException("No existe");
    Joya joyaToUpdate = joya.get();

    joyaToUpdate.setNombre(joyaDTO.getNombre());
    joyaToUpdate.setMaterial(joyaDTO.getMaterial());
    joyaToUpdate.setParticularidad(joyaDTO.getParticularidad());
    joyaToUpdate.setPeso(joyaDTO.getPeso());
    joyaToUpdate.setPoseePiedra(joyaDTO.getPoseePiedra());
    joyaToUpdate.setVentaONo(joyaDTO.getVentaONo());
    joyaRepository.save(joyaToUpdate);

    return mapToJoyaDto(joyaToUpdate);
  }

  private JoyaDTO mapToJoyaDto(Joya joya) {
    return JoyaDTO.builder()
        .numeroIdentificatorio(joya.getNumeroIdentificatorio())
        .nombre(joya.getNombre())
        .material(joya.getMaterial())
        .ventaONo(joya.getVentaONo())
        .particularidad(joya.getParticularidad())
        .peso(joya.getPeso())
        .poseePiedra(joya.getPoseePiedra())
        .build();
  }


}
