package com.bootcamp.elastic.service;

import com.bootcamp.elastic.entity.Obra;
import com.bootcamp.elastic.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService implements IObraService {

    ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository){
        this.obraRepository = obraRepository;
    }

    @Override
    public Obra updateEmployee(Obra obra) {
        /*
        Obra obra1 = obraRepository.findByNombre(obra.getNombre());
        System.out.println(obra1);
        if(obra.getApellido()!=null){
            obra1.setApellido(obra.getApellido());
        }
        //employeeRepository.save(employee1);
        return obra1;

         */
        return null;
    }

    @Override
    public List<Obra> createObras(List<Obra> obras) {
        return (List<Obra>) obraRepository.saveAll(obras);
    }

    @Override
    public List<Obra> findByAutor(String autor) {
        return obraRepository.findByAutor(autor);
    }

    @Override
    public List<Obra> findByNombreContaining(String nombre) {
        return obraRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Obra> findByCantPaginasGreaterThan(Integer cantidadPaginas) {
        return obraRepository.findByCantPaginasGreaterThan(cantidadPaginas);
    }

    @Override
    public List<Obra> findByAnioPublicacionAfter(Integer fecha) {
        return obraRepository.findByAnioPublicacionAfter(fecha);
    }

    @Override
    public List<Obra> findByAnioPublicacionBefore(Integer fecha) {
        return obraRepository.findByAnioPublicacionBefore(fecha);
    }

    @Override
    public List<Obra> findByEditorial(String editorial) {
        return obraRepository.findByEditorial(editorial);
    }


}
