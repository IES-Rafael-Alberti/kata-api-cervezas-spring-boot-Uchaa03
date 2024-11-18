package ucha_barrera.kata_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ucha_barrera.kata_api.entities.brewerie;

public interface brewerieRepository extends JpaRepository<brewerie, Long> {
    Page<brewerie> findAll(Pageable pageable);

}
