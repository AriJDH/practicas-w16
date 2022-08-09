package com.ejerciciointegrador.blog.service;

import com.ejerciciointegrador.blog.dto.EntradaBlogDTO;
import com.ejerciciointegrador.blog.entity.EntradaBlog;
import com.ejerciciointegrador.blog.exception.BadRequestException;
import com.ejerciciointegrador.blog.exception.NotFoundException;
import com.ejerciciointegrador.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public EntradaBlogDTO find(long id) {
        EntradaBlog entradaBlog = iBlogRepository.find(id);
        if (entradaBlog != null) {
            EntradaBlogDTO entradaBlogDTO = modelMapper.map(entradaBlog, EntradaBlogDTO.class);
            return entradaBlogDTO;
        } else if(id<=0){
            throw new BadRequestException("Debe ingresar un id mayor a 0");
        }else{
            throw new NotFoundException("No existe ningun blog registrado con el id " + id);
        }
    }
    @Override
    public List<EntradaBlogDTO> findAll() {
        return iBlogRepository.findAll().stream()
                .map(entradaBlog -> modelMapper.map(entradaBlog, EntradaBlogDTO.class)).collect(Collectors.toList());
    }
    @Override
    public void save(EntradaBlogDTO entradaBlogDTO) {
        ValidateBlogContent(entradaBlogDTO);

        if (iBlogRepository.find(entradaBlogDTO.getId()) == null) {
            EntradaBlog entradaBlog = modelMapper.map(entradaBlogDTO, EntradaBlog.class);
            iBlogRepository.save(entradaBlog);
        } else {
            throw new BadRequestException("La entrada ingresada ya existe en nuestros registros");
        }
    }

    private void ValidateBlogContent(EntradaBlogDTO entradaBlogDTO) {
        boolean notNullParameters = entradaBlogDTO.getId() != null && entradaBlogDTO.getTituloDelBlog() != null
                && entradaBlogDTO.getNombreDelAutor() != null && entradaBlogDTO.getFechaDePublicacion() != null;
        String messageError = "";
        Boolean hasErrors = false;
        if(!notNullParameters){
            messageError = "Debe enviar todos los parametros para crear el blog";
            hasErrors = true;
        } else if(entradaBlogDTO.getId() <= 0){
            messageError = "El id debe ser mayor a 0";
            hasErrors = true;
        } else if(entradaBlogDTO.getTituloDelBlog().isEmpty()){
            messageError = "Debe cargar un titulo para el blog";
            hasErrors = true;
        } else if(entradaBlogDTO.getNombreDelAutor().isEmpty()){
            messageError = "Debe cargar el nombre del autor para el blog";
            hasErrors = true;
        }

        if(hasErrors){
            throw new BadRequestException(messageError);
        }
    }
}
