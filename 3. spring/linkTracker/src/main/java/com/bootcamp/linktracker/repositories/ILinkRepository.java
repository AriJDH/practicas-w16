package com.bootcamp.linktracker.repositories;

import com.bootcamp.linktracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkRepository {
  LinkDTO save(LinkDTO link);

  Optional<LinkDTO> findLinkByLinkId(Integer linkId);

  void delete(LinkDTO linkDTO);
}