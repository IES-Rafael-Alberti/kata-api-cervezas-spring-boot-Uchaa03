package ucha_barrera.kata_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucha_barrera.kata_api.entities.brewerie;
import ucha_barrera.kata_api.entities.category;
import ucha_barrera.kata_api.repositories.brewerieRepository;


@RestController
@RequestMapping("/api/breweries")
public class brewerieController {

        @Autowired
        private brewerieRepository brewerieRepository;

        @GetMapping
        public Page<brewerie> getAllBreweries(Pageable pageable) { return brewerieRepository.findAll( pageable); }

        @GetMapping("/{id}")
        public ResponseEntity<brewerie> getBrewById(@PathVariable Long id) { return brewerieRepository.findById(id)
                .map(ResponseEntity::ok)  // Devuelve 200 OK si se encuentra el libro
                .orElse(ResponseEntity.notFound().build());  // Devuelve 404 si no se encuentra
        }

}
