package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService implements IPublicationService {

  @Autowired
  IPublicationRepository iPublicationRepository;
  @Autowired
  IUserService iUserService;

  @Autowired
  IProductService iProductService;


  @Override
  public ListProductByDateDTO getListProductByDate(Integer userId, String order) {

    List<User> users = iUserService.orderListUserFollowed(userId, "").getFollowed();
    List<Publication> sellers = getListSeller(users);
    List<PostDTO> listDTO = listOrderByWeekend(sellers);
    if (order.equals("date_desc")) {
      listDTO = listDTO.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
    }
    return new ListProductByDateDTO(userId, listDTO);
  }

  private List<Publication> getListSeller(List<User> users) {
    List<Publication> sellers = new ArrayList<>();
    for (User user : users) {
      List<Publication> publications = iPublicationRepository.getListPublicationsById(user.getUserId());
      if (publications != null && publications.size() > 0) {
        sellers.addAll(publications);
      }
    }
    return sellers;
  }

  private List<PostDTO> listOrderByWeekend(List<Publication> publications) {
    LocalDate date = LocalDate.now().minusDays(15);
    List<PostDTO> result = publications.stream()
        .filter(x -> x.getDate().isAfter(date))
        .map(p -> new PostDTO(p.getPublicationId(), p.getUserId(),
            p.getDate(), iProductService.getProductById(p.getProductId()), p.getCategory(), p.getPrice()))
        .sorted(Comparator.comparing(PostDTO::getDate).reversed())
        .collect(Collectors.toList());

    return result;
  }


  @Override
  public Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO) {

    PublicationDTO publicationDTO = new PublicationDTO(requestCreatePublicationDTO.getUserId(),
        requestCreatePublicationDTO.getDate(),
        requestCreatePublicationDTO.getCategory(),
        requestCreatePublicationDTO.getPrice(),
        requestCreatePublicationDTO.getProduct().getProductId());

    Publication publication = iPublicationRepository.createPublication(publicationDTO);

    return publication != null;
  }
}
