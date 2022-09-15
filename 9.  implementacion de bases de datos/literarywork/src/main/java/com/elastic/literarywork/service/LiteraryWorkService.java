package com.elastic.literarywork.service;

import com.elastic.literarywork.dto.ReqLiteraryWorkDTO;
import com.elastic.literarywork.model.LiteraryWork;
import com.elastic.literarywork.repository.LiteraryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LiteraryWorkService {
    @Autowired
    LiteraryWorkRepository literaryWorkRepository;
    public void addOne(ReqLiteraryWorkDTO reqLiteraryWorkDTO) {
        LiteraryWork literaryWork = new LiteraryWork();
        literaryWork.setTitle(reqLiteraryWorkDTO.getTitle());
        literaryWork.setAuthor(reqLiteraryWorkDTO.getAuthor());
        literaryWork.setAmountPages(reqLiteraryWorkDTO.getAmountPages());
        literaryWork.setPublisher(reqLiteraryWorkDTO.getPublisher());
        literaryWork.setYearPublication(reqLiteraryWorkDTO.getYearPublication());
        this.literaryWorkRepository.save(literaryWork);
    }
    public List<LiteraryWork> findAllByAuthor(String author) {
        return this.literaryWorkRepository.findAllByAuthor(author);
    }
    public List<LiteraryWork> findAllByTitleContaining(String title) {
        return this.literaryWorkRepository.findAllByTitleContaining(title);
    }
    public List<LiteraryWork> findAllByAmountPagesGreaterThanEqual(Integer pages) {
        return this.literaryWorkRepository.findAllByAmountPagesGreaterThanEqual(pages);
    }
    public List<LiteraryWork> findAllByAmountPagesLessThanEqual(Integer pages) {
        return this.literaryWorkRepository.findAllByAmountPagesLessThanEqual(pages);
    }
    public List<LiteraryWork> findAllByYearPublicationBefore(LocalDate before) {
        return this.literaryWorkRepository.findAllByYearPublicationBefore(before);
    }
    public List<LiteraryWork> findAllByYearYearPublicationAfter(LocalDate after) {
        return this.literaryWorkRepository.findAllByYearPublicationAfter(after);
    }
    public List<LiteraryWork> findAllByPublisherEquals(String publisher) {
        return this.literaryWorkRepository.findAllByPublisherEquals(publisher);
    }
}
