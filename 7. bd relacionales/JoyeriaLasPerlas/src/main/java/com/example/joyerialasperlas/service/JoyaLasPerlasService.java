package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.NewJoyaDto;
import com.example.joyerialasperlas.dto.ResponseIdDto;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.repository.IJoyaLasPerlasRepository;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaLasPerlasService implements IJoyaLasperlasService{


    private final IJoyaLasPerlasRepository joyasRepo;

    public JoyaLasPerlasService(IJoyaLasPerlasRepository joyasRepo) {
        this.joyasRepo = joyasRepo;
    }


    @Override
    public List<JoyaDto> getJoyas() {
        return joyasRepo.findAll().stream()
                .filter(x->x.isVentaONo())
                .map(x->new JoyaDto(x.getNro_identificatorio(),x.getNombre(),x.getMaterial(),x.getPeso(),x.getParticularidad(),x.isPosee_piedra(),x.isVentaONo()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseIdDto saveJoya(NewJoyaDto joya) {
        Joya nuevaJoya = new Joya();
        nuevaJoya.setNombre(joya.getNombre());
        nuevaJoya.setMaterial(joya.getMaterial());
        nuevaJoya.setParticularidad(joya.getParticularidad());
        nuevaJoya.setPeso(joya.getPeso());
        nuevaJoya.setPosee_piedra(joya.isPosee_piedra());
        nuevaJoya.setVentaONo(joya.isVentaONo());
        return new ResponseIdDto(joyasRepo.save(nuevaJoya).getNro_identificatorio());
    }

    @Override
    public void logicDeleteJoya(long id) {
        Joya joya = findJoya(id);
        joya.setVentaONo(false);
        joyasRepo.save(joya);
    }

    @Override
    public JoyaDto editJoya(long id, JoyaDto joyaEdit) {
        Joya joya = findJoya(id);
        joya.setNombre(joyaEdit.getNombre());
        joya.setMaterial(joyaEdit.getMaterial());
        joya.setParticularidad(joyaEdit.getParticularidad());
        joya.setPeso(joyaEdit.getPeso());
        joya.setPosee_piedra(joyaEdit.isPosee_piedra());
        joya.setVentaONo(joyaEdit.isVentaONo());

        joyasRepo.save(joya);
        return new JoyaDto(joya.getNro_identificatorio(),joya.getNombre(),joya.getMaterial(),joya.getPeso(),joya.getParticularidad(),joya.isPosee_piedra(),joya.isVentaONo());
    }


    private Joya findJoya(long id) {
        return joyasRepo.findById(id).orElse(null);
    }
}
