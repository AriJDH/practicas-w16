package Repository;

import com.example.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMinisierieRepository extends JpaRepository<MiniSerie,Long> {
}
