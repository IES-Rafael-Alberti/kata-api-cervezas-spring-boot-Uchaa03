package ucha_barrera.kata_api.controllers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ucha_barrera.kata_api.entities.beer;
import ucha_barrera.kata_api.repositories.beerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beer")
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
        if (beer.getBrewery_id() != null) {
            beer.setBrewery_id(beer.getBrewery_id());
        }
        if (beer.getCat_id() != null) {
            beer.setCat_id(beer.getCat_id());
        }
        if (beer.getStyle_id() != null) {
            beer.setStyle_id(beer.getStyle_id());
        }
        return ResponseEntity.ok(beerRepository.save(beer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBeer(@PathVariable Long id) {
        return beerRepository.findById(id)
                .map(libro -> {
                    beerRepository.delete(libro);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<beer> updateBeer(@PathVariable Long id, @RequestBody beer beerDetails) {
        return beerRepository.findById(id)
                .map(existingBeer -> {
                    if (beerDetails.getName() != null) {
                        existingBeer.setName(beerDetails.getName());
                    }
                    if (beerDetails.getAbv() != null) {
                        existingBeer.setAbv(beerDetails.getAbv());
                    }
                    if (beerDetails.getIbu() != null) {
                        existingBeer.setIbu(beerDetails.getIbu());
                    }
                    if (beerDetails.getUpc() != null) {
                        existingBeer.setUpc(beerDetails.getUpc());
                    }
                    if (beerDetails.getFilepath() != null) {
                        existingBeer.setFilepath(beerDetails.getFilepath());
                    }
                    if (beerDetails.getDescription() != null) {
                        existingBeer.setDescription(beerDetails.getDescription());
                    }
                    if (beerDetails.getBrewery_id() != null) {
                        existingBeer.setBrewery_id(beerDetails.getBrewery_id());
                    }
                    if (beerDetails.getCat_id() != null) {
                        existingBeer.setCat_id(beerDetails.getCat_id());
                    }
                    if (beerDetails.getStyle_id() != null) {
                        existingBeer.setStyle_id(beerDetails.getStyle_id());
                    }
                    if (beerDetails.getLast_mod() != null) {
                        existingBeer.setLast_mod(beerDetails.getLast_mod());
                    }

                    // Guardar los cambios
                    beer updatedBeer = beerRepository.save(existingBeer);
                    return ResponseEntity.ok(updatedBeer);  // Devuelve 200 OK con la cerveza actualizada
                })
                .orElse(ResponseEntity.notFound().build());  // Devuelve 404 si no se encuentra la cerveza
    }


}
