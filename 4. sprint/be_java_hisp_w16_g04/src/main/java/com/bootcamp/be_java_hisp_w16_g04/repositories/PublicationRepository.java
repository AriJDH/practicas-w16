package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PublicationRepository implements IPublicationRepository {
  List<Publication> publications = new ArrayList<Publication>();

  @PostConstruct
  private void loadData() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date1 = LocalDate.parse("09-08-2022", dtf);
    LocalDate date2 = LocalDate.parse("18-04-2022", dtf);


    publications.add(new Publication(100, date1, 100, 150.0, 100));
    publications.add(new Publication(104, date2, 190, 350.0, 200));

  }
}
