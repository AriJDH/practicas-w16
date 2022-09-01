package com.tomas.joyeria.service;

import com.tomas.joyeria.dto.JoyaDTO;
import com.tomas.joyeria.dto.ListaJoyaDTO;
import com.tomas.joyeria.dto.RespuestaActualizadoDTO;
import com.tomas.joyeria.dto.RespuestaCreadoDTO;
import com.tomas.joyeria.model.Joya;
import com.tomas.joyeria.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements IJoyeriaService{

    @Autowired
    IJoyaRepository joyaRepository;

    @Override
    public RespuestaCreadoDTO crearJoya(JoyaDTO joyaDTO) {

        Long idJoya;
        idJoya = joyaRepository.save(joyaDTOAJoyaModelo(joyaDTO)).getNumeroId();

        return this.construirRespuesta(idJoya);
    }

    @Override
    public ListaJoyaDTO listarJoya() {

        ListaJoyaDTO lista = new ListaJoyaDTO();

        lista.setJoya(joyaRepository.findAll().stream().filter(y->y.isVentaONo()==true).map(x->{
          JoyaDTO joyaDTO = new JoyaDTO();
          joyaDTO.setNombre(x.getNombre());
          joyaDTO.setMaterial(x.getMaterial());
          joyaDTO.setParticularidad(x.getParticularidad());
          joyaDTO.setPeso(x.getPeso());
          joyaDTO.setPoseePiedra(x.isPoseePiedra());
          joyaDTO.setVentaONo(x.isVentaONo());

          return  joyaDTO;
        }).collect(Collectors.toList()));

        return lista;

    }

    @Override
    public void eliminarJoya(Long id) {


        if(joyaRepository.existsById(id)) {

            Joya joya;
            joya = joyaRepository.findById(id).get();
            joya.setNumeroId(id);
            joya.setVentaONo(false);

            joyaRepository.save(joya);

        }


    }

    @Override
    public RespuestaActualizadoDTO actualizarJoya(Long id, JoyaDTO joyaDTO) {

        Joya joya ;
        joya = joyaRepository.findById(id).orElse(null);

        joya.setPeso(joyaDTO.getPeso());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setNombre(joyaDTO.getNombre());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.isPoseePiedra());
        joya.setVentaONo(joyaDTO.isVentaONo());

        joyaRepository.save(joya);

        ArrayList listaActualizada = new ArrayList();
        listaActualizada.add(joyaDTO);
        RespuestaActualizadoDTO respuesta = new RespuestaActualizadoDTO(200, "Registro actualizado");
        respuesta.setJoya(listaActualizada);

        return respuesta;
    }

    private Joya joyaDTOAJoyaModelo(JoyaDTO joyaDTO){

        Joya joyaModel = new Joya();
        joyaModel.setNombre(joyaDTO.getNombre());
        joyaModel.setMaterial(joyaDTO.getMaterial());
        joyaModel.setParticularidad(joyaDTO.getParticularidad());
        joyaModel.setPeso(joyaDTO.getPeso());
        joyaModel.setPoseePiedra(joyaDTO.isPoseePiedra());
        joyaModel.setVentaONo(joyaDTO.isVentaONo());

        return joyaModel;

    }



    private RespuestaCreadoDTO construirRespuesta (Long idJoya){

        RespuestaCreadoDTO respuestaCreadoDTO = new RespuestaCreadoDTO(201, idJoya);
        return respuestaCreadoDTO;

    }
}
