package com.javaW16.joyeriaLasPerlas.service;

import java.util.List;

import com.javaW16.joyeriaLasPerlas.dto.reqDTO.JoyaReqDTO;
import com.javaW16.joyeriaLasPerlas.dto.resDTO.JoyaResDTO;

public interface IService {

   JoyaResDTO createJoya (JoyaReqDTO joya);   

   void updateJoya (JoyaReqDTO joya,Long id);   

   Boolean deleteJoya (Long id);   

   List<JoyaResDTO> listAll ();   

   JoyaResDTO findById (Long id);   

}
