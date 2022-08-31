package com.implementacionbd.Joyeria.service;


import com.implementacionbd.Joyeria.dto.JoyaDTO;
import com.implementacionbd.Joyeria.dto.ResponseDTO;
import com.implementacionbd.Joyeria.dto.ResponseJoyaDTO;
import com.implementacionbd.Joyeria.model.Joya;
import com.implementacionbd.Joyeria.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;
    private final ModelMapper mapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ResponseDTO save(JoyaDTO joyaDTO) {
        Joya joya = mapper.map(joyaDTO,Joya.class);
        joyaRepository.save(joya);
        int id=joyaRepository.findAll().size();
        return new ResponseDTO("Crate", "Joya with id "+id+" is Created");
    }

    @Override
    public List<ResponseJoyaDTO> getJoyas() {
        return joyaRepository.findAll().stream()
                .filter(Joya::isVentaONo)
                .map(u->mapper.map(u,ResponseJoyaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseJoyaDTO getJoya(Long id) {
        return mapper.map(joyaRepository.findById(id).orElse(null),ResponseJoyaDTO.class);
    }

    @Override
    public ResponseDTO deleteJoya(Long id) {

        Joya joya = joyaRepository.findById(id).orElse(null);
        if (joya!= null){
            joya.setVentaONo(false);
            joyaRepository.save(joya);
            return new ResponseDTO("Delete Joya","Joya whit id "+id+" is Deleted");
        }else{
            return new ResponseDTO("Delete Joya","Joya whit id "+id+" not Exists");
        }
    }

    @Override
    public ResponseDTO editJoya(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        
        if (joya!= null){
            joya.setNombre(joyaDTO.getNombre());
            joya.setMaterial(joyaDTO.getMaterial());
            joya.setPeso(joyaDTO.getPeso());
            joya.setParticularidad(joyaDTO.getParticularidad());
            joya.setPoseePriedra(joyaDTO.isPoseePriedra());
            joya.setVentaONo(joyaDTO.isVentaONo());

            joyaRepository.save(joya);
            return new ResponseDTO("Update Joya","Joya whit id "+id+" is Update");
        }else{
            return new ResponseDTO("Update Joya","Joya whit id "+id+" not Exists");
        }
    }
}
