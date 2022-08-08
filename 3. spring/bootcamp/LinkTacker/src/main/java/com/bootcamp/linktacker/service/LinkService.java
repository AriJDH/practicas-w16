package com.bootcamp.linktacker.service;

import com.bootcamp.linktacker.dto.*;
import com.bootcamp.linktacker.entity.Link;
import com.bootcamp.linktacker.exception.InvalidUrlException;
import com.bootcamp.linktacker.repository.ILinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository repository;
    private final ModelMapper mapper ;

    public LinkService(ILinkRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    private Integer counterId = 1;
    private Integer counterMetrics = 1;


    @Override
    public CreatedLinkDto createLink(LinkDto linkDto) {

        boolean validateLink = validateLink(linkDto.getLink());

        String password = "passMeli";

        Link link = new Link(counterId, linkDto.getLink(), validateLink, password, 0);
        repository.createLink(link);

        counterId++;

        return new CreatedLinkDto(link.getId(), link.getPassword());
    }

    @Override
    public List<AllInfoLinkDto> showAllLinks() {
        return repository.getAllLinks().stream()
                .map(link -> mapper.map(link, AllInfoLinkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void redirect(Integer id, HttpServletResponse response, String password) {
       Link link = repository.getLinkById(id);

       if(link.isValid() && password.equals(link.getPassword())){
           try {
               response.sendRedirect(link.getLink());
               link.setMetric(counterMetrics);
               counterMetrics ++;
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }else{
           throw new InvalidUrlException(id);
       }

    }

    @Override
    public MetricResponseDto metrics(Integer id) {
        return new MetricResponseDto(repository.getLinkById(id).getMetric());
    }

    @Override
    public ApiResponseDto invalidateLink(Integer id) {
        Link link = repository.getLinkById(id);
        link.setValid(false);
        return new ApiResponseDto("Invalidación de link", "Link con id: " + id + " ha sido invalidado");
    }

    private boolean validateLink(String link){

        Pattern p = Pattern.compile("((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)");

        Matcher m = p.matcher(link);

        return m.matches();
    }

}
