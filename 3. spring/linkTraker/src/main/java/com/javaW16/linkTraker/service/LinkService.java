package com.javaW16.linkTraker.service;

import com.javaW16.linkTraker.dto.LinkDto;
import com.javaW16.linkTraker.dto.ResponseDeletedDTO;
import com.javaW16.linkTraker.dto.ResponseMetricsDTO;
import com.javaW16.linkTraker.dto.ResponseNewLinkDTO;
import com.javaW16.linkTraker.exception.BadPasswordException;
import com.javaW16.linkTraker.exception.IdNotFoundException;
import com.javaW16.linkTraker.exception.UrlAlreadyExistException;
import com.javaW16.linkTraker.model.Link;
import com.javaW16.linkTraker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.net.URLConnection;

@Service
public class LinkService implements ILinkService {

   @Autowired
   LinkRepository repository;

   @Override
   public ResponseNewLinkDTO createLinkService(LinkDto link) throws Exception {

      URL url = new URL(link.getUrl());
      URLConnection conn = url.openConnection();
      conn.connect();

      if (repository.getLinks().get(link.getUrl()) == null) {
         Integer id = repository.getId();

         Link nuevoLink = new Link(id, link.getUrl(), (int) (Math.random() * (9999 - 1000 + 1) + 1000), 0);

         repository.addLink(nuevoLink);

         return new ResponseNewLinkDTO(id, nuevoLink.getPassword());
      } else {
         throw new UrlAlreadyExistException("La url ya existe en base de datos");
      }
   }

   @Override
   public String redirectLinkService(Integer id,Integer password) {
      if (repository.getInvertLinks().get(id) == null) {
         throw new IdNotFoundException("La id: " + id + " no se encuenta registrada.");
      }else if(!repository.getLinks().get(repository.getInvertLinks().get(id)).getPassword().equals(password)) {
        throw new BadPasswordException("La contraseña no es correcta.") ;
      }
      else {
         String url = repository.getInvertLinks().get(id);
         repository.plusOneVisit(url);
         return url;
      }
   }

   @Override
   public ResponseMetricsDTO getMetricsByIdService(Integer id) {
      if (repository.getInvertLinks().get(id) == null) {
         throw new IdNotFoundException("La id: " + id + " no se encuenta registrada.");
      } else {
         String url = repository.getInvertLinks().get(id);
         return ResponseMetricsDTO.builder()
               .url(repository.getLinks().get(url).getUrl())
               .nVisits(repository.getLinks().get(url).getNVisits())
               .build();
      }
   }

   @Override
   public ResponseDeletedDTO deleteLinkByIdService(Integer id) {
      if (repository.getInvertLinks().get(id) == null) {
         throw new IdNotFoundException("La id: " + id + " no se encuenta registrada.");
      } else {
         String url = repository.getInvertLinks().get(id);
         repository.deleteById(url,id);
         return ResponseDeletedDTO.builder()
               .url(url)
               .message("El link fue dado de baja con exito.")
               .build();
      }
   }

}
