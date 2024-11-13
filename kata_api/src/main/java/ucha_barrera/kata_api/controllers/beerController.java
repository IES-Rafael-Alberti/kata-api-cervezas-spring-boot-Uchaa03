package ucha_barrera.kata_api.controllers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ucha_barrera.kata_api.entities.beer;
import ucha_barrera.kata_api.repositories.beerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beers")
public class beerController {

    @Autowired
    private beerRepository beerRepository;

    @GetMapping
    public Page<beer> getAllBeers(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<beer> getBeerById(@PathVariable Long id) {
        return beerRepository.findById(id)
                .map(ResponseEntity::ok)  // Devuelve 200 OK si se encuentra el libro
                .orElse(ResponseEntity.notFound().build());  // Devuelve 404 si no se encuentra
    }

    @PostMapping()
    public ResponseEntity<beer> createBeer(@RequestBody beer beer) {
        return ResponseEntity.ok(beerRepository.save(beer));
    }

    @DeleteMapping()
    public ResponseEntity deleteBeer(@PathVariable Long id) {
        return beerRepository.findById(id)
                .map(libro -> {
                    beerRepository.delete(libro);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
