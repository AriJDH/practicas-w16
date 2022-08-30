package com.bootcamp.be_java_hisp_w16_g04.util;

import com.bootcamp.be_java_hisp_w16_g04.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilsGenerator {

    public static List<Follower> createListFollowers() {
        List<Follower> followers = new ArrayList<Follower>();
        followers.add(new Follower(100, 101));
        followers.add(new Follower(102, 105));
        followers.add(new Follower(101, 103));

        return followers;
    }

    public static List<User> createListUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(103, "David Lozano"));
        users.add(new User(104, "Tannia Hernandez"));
        users.add(new User(105, "Ana Delgado"));

        return users;
    }

    public static List<User> getFollowedUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(104, "Tannia Hernandez"));

        return users;
    }

    public static List<Publication> getListPublications() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString1 = LocalDate.now().minusDays(8).format(dtf);
        String dateString2 = LocalDate.now().minusDays(4).format(dtf);
        String dateString3 = LocalDate.now().minusDays(18).format(dtf);
        LocalDate date1 = LocalDate.parse(dateString1, dtf);
        LocalDate date2 = LocalDate.parse(dateString2, dtf);
        LocalDate date3 = LocalDate.parse(dateString3, dtf);

        List<Publication> publications = new ArrayList<>();
        publications.add(new Publication(104, 1, date1, 100, 100, 150.0));
        publications.add(new Publication(104, 2, date2, 200, 200, 350.0));
        publications.add(new Publication(104, 3, date3, 200, 200, 250.0));

        return publications;
    }

    public static ProductDTO getProductDTO() {
        ProductDTO productDTO = new ProductDTO(100, "Silla gamer", "Gamer", "Racer", "Negro", "usado");
        return productDTO;
    }

    public static List<PostDTO> getListPostsDTOSAsc() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String dateString1 = LocalDate.now().minusDays(8).format(dtf);
        String dateString2 = LocalDate.now().minusDays(4).format(dtf);
        LocalDate date1 = LocalDate.parse(dateString1, dtf);
        LocalDate date2 = LocalDate.parse(dateString2, dtf);

        List<PostDTO> postDTOS = Arrays.asList(new PostDTO(1, 104, date1, getProductDTO(), 100, 150.0),
                new PostDTO(2, 104, date2, getProductDTO(), 200, 350.0));

        return postDTOS;
    }

    public static List<PostDTO> getListPostsDTOSDesc() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String dateString1 = LocalDate.now().minusDays(4).format(dtf);
        String dateString2 = LocalDate.now().minusDays(8).format(dtf);
        LocalDate date1 = LocalDate.parse(dateString1, dtf);
        LocalDate date2 = LocalDate.parse(dateString2, dtf);

        List<PostDTO> postDTOS = Arrays.asList(new PostDTO(2, 104, date1, getProductDTO(), 200, 350.0),
                new PostDTO(1, 104, date2, getProductDTO(), 100, 150.0));

        return postDTOS;
    }


}
