package com.meli.linktracker.repository;


import com.meli.linktracker.dto.LinkDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlRepository {


    private List<LinkDto> listaLink = new ArrayList<>();


    public void agregarLink(LinkDto link)
    {
        listaLink.add(link);
    }

    public String getUrl(int id)
    {
        return listaLink.stream().filter(x-> x.getId()==id).findFirst().orElse(null).getUrl();
    }

    public LinkDto getLink(int id)
    {
        return  this.listaLink.stream().filter(x->x.getId()==id).findFirst().get();
    }


    public void addSolicitudes(int id)
    {
        this.listaLink.stream().filter(x-> x.getId()==id).findFirst().get().addSolicitudes();
    }
}
