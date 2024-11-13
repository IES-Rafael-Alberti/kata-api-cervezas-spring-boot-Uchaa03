package ucha_barrera.kata_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ucha_barrera.kata_api.entities.beer;

public interface beerRepository extends JpaRepository<beer, Long> {
    Page<beer> findAll(Pageable pageable);

    Page<beer> findById(Long id, Pageable pageable);
}
