package com.elastic.literarywork.repository;

import com.elastic.literarywork.model.LiteraryWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findAllByAuthor(String author);
    List<LiteraryWork> findAllByTitleContaining(String title);
    List<LiteraryWork> findAllByAmountPagesGreaterThanEqual(Integer pages);
    List<LiteraryWork> findAllByAmountPagesLessThanEqual(Integer pages);
    List<LiteraryWork> findAllByYearPublicationBefore(LocalDate before);
    List<LiteraryWork> findAllByYearPublicationAfter(LocalDate after);
    List<LiteraryWork> findAllByPublisherEquals(String publisher);
}
