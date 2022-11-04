package br.com.digitalhouse.controllers;

import br.com.digitalhouse.dtos.FeatureDto;
import br.com.digitalhouse.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/features")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping
    public ResponseEntity<List<FeatureDto>> searchAllFeatures() {
        List<FeatureDto> list = featureService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FeatureDto> searchFeatureById(@PathVariable Integer id) {
        FeatureDto dto = featureService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<FeatureDto> insertFeature(@RequestBody FeatureDto dto) {
        dto = featureService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FeatureDto> updateFeature(@PathVariable Integer id, @RequestBody FeatureDto dto) {
        dto = featureService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Integer id) {
        featureService.delete(id);
        return ResponseEntity.noContent().build();
    }

}