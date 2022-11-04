package br.com.digitalhouse.controllers;

import br.com.digitalhouse.dtos.CityDto;
import br.com.digitalhouse.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDto>> searchAllCities() {
        List<CityDto> list = cityService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> searchCityById(@PathVariable Integer id) {
        CityDto dto = cityService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CityDto> insertCity(@RequestBody CityDto dto) {
        dto = cityService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> updateCity(@PathVariable Integer id, @RequestBody CityDto dto) {
        dto = cityService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }

}