package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

  List<User> users = new ArrayList<User>();

  @PostConstruct
  private void loadData() {
    users.add(new User(100, "Andres Roa"));
    users.add(new User(101, "Javier Aguayo"));
    users.add(new User(102, "Ruth Cano"));
    users.add(new User(103, "David Lozano"));
    users.add(new User(104, "Tannia Hernandez"));
    users.add(new User(105, "Ana Delgado"));
    users.add(new User(106, "Kevin Molano"));

  }


  @Override
  public User getByIdUser(Integer userId) {
    return users.stream()
        .filter(x -> x.getUserId().equals(userId))
        .findFirst()
        .orElse(null);
  }

}
