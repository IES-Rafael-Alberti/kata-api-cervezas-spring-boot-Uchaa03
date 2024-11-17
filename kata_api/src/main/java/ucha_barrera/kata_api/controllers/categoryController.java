package ucha_barrera.kata_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucha_barrera.kata_api.entities.category;
import ucha_barrera.kata_api.repositories.categoryRepository;

@RestController
@RequestMapping("/api/category")
public class categoryController {

    @Autowired
    private categoryRepository categoryRepository;

    @GetMapping
    public Page<category> getAllBreweries(Pageable pageable) { return categoryRepository.findAll( pageable); }

    @GetMapping("/{id}")
    public ResponseEntity<category> getBrewById(@PathVariable Long id) { return categoryRepository.findById(id)
            .map(ResponseEntity::ok)  // Devuelve 200 OK si se encuentra el libro
            .orElse(ResponseEntity.notFound().build());  // Devuelve 404 si no se encuentra
    }
}
