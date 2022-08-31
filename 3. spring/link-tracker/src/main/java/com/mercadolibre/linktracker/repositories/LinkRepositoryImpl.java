package com.mercadolibre.linktracker.repositories;

import com.mercadolibre.linktracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements LinkRepository {
  private final Map<Integer, LinkDTO> database = new HashMap<>();

  @Override
  public LinkDTO save(LinkDTO link) {
    if (link.getLinkId() == null)
      link.setLinkId(database.values().size());
    database.put(link.getLinkId(), link);
    return link;
  }

  @Override
  public Optional<LinkDTO> findLinkByLinkId(Integer linkId) {
    LinkDTO linkDTO = database.get(linkId);
    return Optional.ofNullable(linkDTO);
  }

  @Override
  public void delete(LinkDTO linkDTO) {
    database.remove(linkDTO.getLinkId());
  }
}
