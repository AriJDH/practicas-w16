package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {
  private final LinkRepository linkRepository;

  public LinkService(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  @Override
  public LinkDTO create(LinkDTO link) {
    return linkRepository.save(link);
  }

  @Override
  public LinkDTO redirect(Integer linkId) {
    Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
    link.ifPresent(this::sumMetric);
    return link.orElse(null);
  }

  @Override
  public LinkDTO redirect(Integer linkId, String password) {
    Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
    LinkDTO result = null;
    if (link.isPresent())
      result = checkLinkAndPassword(password, link.get());
    return result;
  }

  private LinkDTO checkLinkAndPassword(String password, LinkDTO linkDTO) {
    LinkDTO result = null;
    if (linkDTO.getPassword() != null && linkDTO.getPassword().equals(password)){
      result = linkDTO;
      sumMetric(linkDTO);
    }
    return result;
  }

  private void sumMetric(LinkDTO linkDTO) {
    linkDTO.sumCount();
    linkRepository.save(linkDTO);
  }

  @Override
  public LinkDTO metrics(Integer linkId) {
    Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
    return link.orElse(null);
  }

  @Override
  public void invalidate(Integer linkId) {
    Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
    link.ifPresent(linkRepository::delete);
  }
}
