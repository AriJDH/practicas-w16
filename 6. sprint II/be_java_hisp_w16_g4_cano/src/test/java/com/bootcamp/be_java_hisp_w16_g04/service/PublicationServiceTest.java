package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PublicationServiceTest {

  @Mock
  IPublicationRepository iPublicationRepository;

  @Mock
  IUserService iUserService;

  @Mock
  IProductService iProductService;


  @InjectMocks
  PublicationService publicationService;

  @Test
  @DisplayName("Verify that the sort by date exists.")
  void getProductsByDateAsc() {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String nowString = LocalDate.now().format(dtf);
    LocalDate nowDate = LocalDate.parse(nowString, dtf);

    ProductDTO productDTO = new ProductDTO(56, "Leche en polvo", "Leche", "Colanta", "Blanco", "Nota");

    PostDTO post1 = new PostDTO(101, 1, nowDate, productDTO, 190, 100.0);
    PostDTO post2 = new PostDTO(102, 2, nowDate, productDTO, 191, 200.0);

    ListProductByDateDTO expectList = new ListProductByDateDTO(100, List.of(post1, post2, post1, post2));
    User user0 = new User(100, "Mariana");
    User user1 = new User(101, "Andres");

    Publication publication0 = new Publication(1, 101, nowDate, 10, 190, 100.0);
    Publication publication1 = new Publication(2, 102, nowDate, 11, 191, 200.0);

    when(iUserService.orderListUserFollowed(100, "")).thenReturn(new UserFollowedDTO(100, "Mariana", List.of(user0, user1)));
    when(iPublicationRepository.getListPublicationsById(Mockito.any())).thenReturn(List.of(publication0, publication1));
    when(iProductService.getProductById(Mockito.any())).thenReturn(productDTO);

    ListProductByDateDTO finalList = publicationService.getListProductByDate(100, "date_desc");

    Assertions.assertEquals(expectList, finalList);
  }


  @Test
  @DisplayName("Verify that the sort by date does not exist.")
  void orderNotFound() {
    Assertions.assertThrows(OrderNotFoundException.class, () -> publicationService.getListProductByDate(12, "dsd"));
  }

  @Test
  @DisplayName("Verify that the order date of the weekend exists.")
  void ListOrderByWeekendExists() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String nowString = LocalDate.now().format(dtf);
    LocalDate nowDate = LocalDate.parse(nowString, dtf);

    LocalDate date2 = LocalDate.parse("01-03-2022", dtf);
    LocalDate date3 = LocalDate.parse("12-08-2021", dtf);

    ProductDTO productDTO = new ProductDTO(56, "Leche en polvo", "Leche", "Colanta", "Blanco", "Nota");

    PostDTO post1 = new PostDTO(101, 1, nowDate, productDTO, 190, 100.0);
    PostDTO post2 = new PostDTO(102, 2, date2, productDTO, 191, 200.0);

    ListProductByDateDTO expectList = new ListProductByDateDTO(100, List.of(post1, post2, post1, post2));
    User user0 = new User(100, "Mariana");
    User user1 = new User(101, "Andres");

    Publication publication1 = new Publication(1, 101, nowDate, 10, 190, 100.0);
    Publication publication2 = new Publication(2, 102, date2, 11, 191, 200.0);
    Publication publication3 = new Publication(2, 102, date3, 11, 191, 200.0);
    Publication publication4 = new Publication(2, 102, nowDate, 11, 191, 200.0);
    Publication publication5 = new Publication(2, 102, nowDate, 11, 191, 200.0);

    when(iUserService.orderListUserFollowed(100, "")).thenReturn(new UserFollowedDTO(100, "Mariana", List.of(user0, user1)));
    when(iPublicationRepository.getListPublicationsById(Mockito.any())).thenReturn(List.of(publication1, publication2, publication3, publication4, publication5));
    when(iProductService.getProductById(Mockito.any())).thenReturn(productDTO);

    ListProductByDateDTO finalList = publicationService.getListProductByDate(100, "date_desc");

    Assertions.assertEquals(6, finalList.getPosts().size());
  }

  @Test
  public void getListProductByDateAsc() {

    List<User> users = TestUtilsGenerator.getFollowedUsers();

    List<Publication> publications = TestUtilsGenerator.getListPublications();

    ProductDTO productDTO = TestUtilsGenerator.getProductDTO();

    List<PostDTO> postDTOS = TestUtilsGenerator.getListPostsDTOSAsc();
    ListProductByDateDTO listProductByDateDTO = new ListProductByDateDTO(106, postDTOS);

    when(iUserService.orderListUserFollowed(106, "")).thenReturn(new UserFollowedDTO(106, "Kevin Molano", users));
    when(iPublicationRepository.getListPublicationsById(Mockito.any())).thenReturn(publications);
    when(iProductService.getProductById(Mockito.any())).thenReturn(productDTO);

    Assertions.assertEquals(listProductByDateDTO, publicationService.getListProductByDate(106, "date_asc"));

  }

  @Test
  public void getListProductByDateDesc() {

    List<User> users = TestUtilsGenerator.getFollowedUsers();

    List<Publication> publications = TestUtilsGenerator.getListPublications();

    ProductDTO productDTO = TestUtilsGenerator.getProductDTO();

    List<PostDTO> postDTOS = TestUtilsGenerator.getListPostsDTOSDesc();
    ListProductByDateDTO listProductByDateDTO = new ListProductByDateDTO(106, postDTOS);

    when(iUserService.orderListUserFollowed(106, "")).thenReturn(new UserFollowedDTO(106, "Kevin Molano", users));
    when(iPublicationRepository.getListPublicationsById(Mockito.any())).thenReturn(publications);
    when(iProductService.getProductById(Mockito.any())).thenReturn(productDTO);

    Assertions.assertEquals(listProductByDateDTO, publicationService.getListProductByDate(106, "date_desc"));
  }

  @Test
  public void createPublicationTest() {
    final Integer userId = 102;
    User user102 = new User(102, "Ruth Cano");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date3 = LocalDate.parse("18-04-2022", dtf);

    PublicationDTO createPublicationDTO = new PublicationDTO();
    createPublicationDTO.setUserId(userId);
    createPublicationDTO.setCategory(76);
    createPublicationDTO.setDate(date3);
    createPublicationDTO.setPrice(110.0);
    createPublicationDTO.setProductId(6);

    Publication result = iPublicationRepository.createPublication(createPublicationDTO);

    Assertions.assertEquals(createPublicationDTO.getUserId(), result.getUserId());
  }
}
