package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;

public interface LinkService {
  LinkDTO create(LinkDTO link);

  LinkDTO redirect(Integer linkId);

  LinkDTO redirect(Integer linkId, String password);

  LinkDTO metrics(Integer linkId);

  void invalidate(Integer linkId);
}
