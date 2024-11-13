package ucha_barrera.kata_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ucha_barrera.kata_api.entities.category;
import ucha_barrera.kata_api.entities.style;

public interface styleRepository extends JpaRepository<style, Long> {


    Page<style> findAll(Pageable pageable);
}
