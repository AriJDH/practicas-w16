package roa.ejemplo.estoessolounejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roa.ejemplo.estoessolounejemplo.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
