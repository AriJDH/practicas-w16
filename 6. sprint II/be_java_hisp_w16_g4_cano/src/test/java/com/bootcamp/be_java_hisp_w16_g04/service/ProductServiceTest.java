package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.FailedToCreateResource;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    IProductRepository iProductRepository;

    @Mock
    IPublicationRepository iPublicationRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void getProductByIdTest() {

        Product product = new Product(6, "Silla gamer", "Gamer", "Racer", "Negro", "usado");

        when(iProductRepository.getProductById(product.getProductId())).thenReturn(product);

        ProductDTO result = productService.getProductById(product.getProductId());

        Assertions.assertNotNull(result);
    }

    @Test
    public void CreateProductFailedToCreateTest() {

        ProductCreateDTO productDTO = new ProductCreateDTO();
        final Integer userId = 102;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date3 = LocalDate.parse("18-04-2022", dtf);

        RequestCreatePublicationDTO requestCreatePublicationDTO = new RequestCreatePublicationDTO();
        requestCreatePublicationDTO.setUserId(userId);
        requestCreatePublicationDTO.setCategory(76);
        requestCreatePublicationDTO.setDate(date3);
        requestCreatePublicationDTO.setPrice(110.0);
        requestCreatePublicationDTO.setProduct(productDTO);

        when(iProductRepository.createProduct(productDTO)).thenReturn(null);

        Assertions.assertThrows(FailedToCreateResource.class, () -> {
            productService.CreateProduct(requestCreatePublicationDTO);
        });
    }

    @Test
    public void CreateProductFailedToCreatePublicationTest() {

        ProductCreateDTO productDTO = new ProductCreateDTO(6, "Silla gamer", "Gamer", "Racer", "Negro", "usado");
        Product product = new Product(6, "Silla gamer", "Gamer", "Racer", "Negro", "usado");

        final Integer userId = 102;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date3 = LocalDate.parse("18-04-2022", dtf);

        RequestCreatePublicationDTO requestCreatePublicationDTO = new RequestCreatePublicationDTO();
        requestCreatePublicationDTO.setUserId(userId);
        requestCreatePublicationDTO.setCategory(76);
        requestCreatePublicationDTO.setDate(date3);
        requestCreatePublicationDTO.setPrice(110.0);
        requestCreatePublicationDTO.setProduct(productDTO);

        PublicationDTO publicationDTO = new PublicationDTO();

        when(iProductRepository.createProduct(productDTO)).thenReturn(product);

        when(iPublicationRepository.createPublication(publicationDTO)).thenReturn(null);

        Assertions.assertThrows(FailedToCreateResource.class, () -> {
            productService.CreateProduct(requestCreatePublicationDTO);
        });
    }
}
