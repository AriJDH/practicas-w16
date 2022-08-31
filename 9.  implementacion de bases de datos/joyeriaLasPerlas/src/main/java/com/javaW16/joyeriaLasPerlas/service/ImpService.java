package com.javaW16.joyeriaLasPerlas.service;

import java.util.List;
import java.util.Optional;

import com.javaW16.joyeriaLasPerlas.dto.reqDTO.JoyaReqDTO;
import com.javaW16.joyeriaLasPerlas.dto.resDTO.JoyaResDTO;
import com.javaW16.joyeriaLasPerlas.model.Joya;
import com.javaW16.joyeriaLasPerlas.repository.IJoyeriaRepository;
import com.javaW16.joyeriaLasPerlas.utils.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImpService implements IService {

   @Autowired
   IJoyeriaRepository repository;

   @Override
   public JoyaResDTO createJoya(JoyaReqDTO joya) {

      Joya joyaEntity = Mapper.joyaDtoToEntity(joya);

      Joya joyaSaved = repository.save(joyaEntity);

      return Mapper.joyaToJoyaResDto(joyaSaved);

   }

   @Override
   public void updateJoya(JoyaReqDTO joya,Long id) {

      Optional<Joya> joyaRes = repository.findById(id);   

      if (!joyaRes.isEmpty()){
        joyaRes.get().setGramos(joya.getGramos()); 
         joyaRes.get().setNombre(joya.getNombre());
         joyaRes.get().setVentas(joya.getVentas());
         joyaRes.get().setMaterial(joya.getMaterial());
         joyaRes.get().setPoseePiedra(joya.getPoseePiedra());
         joyaRes.get().setParticularidad(joya.getParticularidad());

         repository.save(joyaRes.get());   

      }


   }

   @Override
   public Boolean deleteJoya(Long id) {

      try {

         Boolean res = repository.existsById(id);

         repository.deleteById(id);

         return res;

      } catch (Exception e) {

         return false;

      }

   }

   @Override
   public List<JoyaResDTO> listAll() {

      List<Joya> listJoyas = repository.findAll();

      return Mapper.joyaToListJoyaResDTO(listJoyas);

   }

   @Override
   public JoyaResDTO findById(Long id) {

      Optional<Joya> resJoya = repository.findById(id);

      return resJoya.isEmpty() ? null : Mapper.joyaToJoyaResDto(resJoya.get());

   }

}
