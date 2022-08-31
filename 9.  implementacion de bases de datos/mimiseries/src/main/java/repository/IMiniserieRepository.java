package repository;


import model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface IMiniSerieRepository  extends JpaRepository <MiniSerie, Long> {

}
