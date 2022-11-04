package br.com.digitalhouse.services;

import br.com.digitalhouse.dtos.FeatureDto;
import br.com.digitalhouse.entities.Feature;
import br.com.digitalhouse.repositories.FeatureRepository;
import br.com.digitalhouse.services.exceptions.DatabaseCarException;
import br.com.digitalhouse.services.exceptions.EntityCarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    // SearchAll
    @Transactional(readOnly = true)
    public List<FeatureDto> searchAll() {
        try {
            List<Feature> list = featureRepository.findAll();
            return list.stream().map(x -> new FeatureDto(x)).collect(Collectors.toList());
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registros não encontrados!"
            );
        }
    }

    // SearchById
    @Transactional(readOnly = true)
    public FeatureDto searchById(Integer id) {
        Optional<Feature> object = featureRepository.findById(id);
        Feature entity = object.orElseThrow(() -> new EntityCarNotFoundException("Registro: " + id + " não encontrado!"));
        return new FeatureDto(entity);
    }

    // Insert
    @Transactional
    public FeatureDto insert(FeatureDto dto) {
        Feature entity = new Feature();
        copyDtoForEntity(dto, entity);
        entity = featureRepository.save(entity);
        return new FeatureDto(entity);
    }

    // Update
    @Transactional
    public FeatureDto update(Integer id, FeatureDto dto) {
        try {
            Feature entity = featureRepository.getReferenceById(id);
            copyDtoForEntity(dto, entity);
            entity = featureRepository.save(entity);
            return new FeatureDto(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registro " + id + " não encontrado!"
            );
        }
    }

    // Delete
    public void delete(Integer id) {
        try {
            featureRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityCarNotFoundException(
                    "Exclusão não realizada! Registro " + id + " não encontrado!"
            );
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseCarException(
                    "Violação de integridade: Registro " + id + " está em outro registro!"
            );
        }
    }

    private void copyDtoForEntity(FeatureDto dto, Feature entity) {
        entity.setName(dto.getName());
        entity.setIcon(dto.getIcon());
    }

}