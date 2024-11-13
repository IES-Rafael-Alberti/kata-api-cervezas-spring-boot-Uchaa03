package ucha_barrera.kata_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ucha_barrera.kata_api.entities.category;

public interface categoryRepository extends JpaRepository<category, Long> {
    Page<category> findById(Long id, Pageable pageable);

    Page<category> findAll(Pageable pageable);

}
