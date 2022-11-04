package br.com.digitalhouse.services;

import br.com.digitalhouse.dtos.CityDto;
import br.com.digitalhouse.dtos.ProductDto;
import br.com.digitalhouse.entities.City;
import br.com.digitalhouse.entities.Product;
import br.com.digitalhouse.repositories.CityRepository;
import br.com.digitalhouse.repositories.ProductRepository;
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
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ProductRepository productRepository;

    // SearchAll
    @Transactional(readOnly = true)
    public List<CityDto> searchAll() {
        try {
            List<City> list = cityRepository.findAll();
            return list.stream().map(x -> new CityDto(x)).collect(Collectors.toList());
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registros não encontrados!"
            );
        }
    }

    // SearchById
    @Transactional(readOnly = true)
    public CityDto searchById(Integer id) {
        Optional<City> object = cityRepository.findById(id);
        City entity = object.orElseThrow(() -> new EntityCarNotFoundException("Registro: " + id + " não encontrado!"));
        return new CityDto(entity);
    }

    // Insert
    @Transactional
    public CityDto insert(CityDto dto) {
        City entity = new City();
        copyDtoForEntity(dto, entity);
        entity = cityRepository.save(entity);
        return new CityDto(entity);
    }

    // Update
    @Transactional
    public CityDto update(Integer id, CityDto dto) {
        try {
            City entity = cityRepository.getReferenceById(id);
            copyDtoForEntity(dto, entity);
            entity = cityRepository.save(entity);
            return new CityDto(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registro " + id + " não encontrado!"
            );
        }
    }

    // Delete
    public void delete(Integer id) {
        try {
            cityRepository.deleteById(id);
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

    private void copyDtoForEntity(CityDto dto, City entity) {
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());

        entity.getProducts().clear();
        for (ProductDto productDto : dto.getProducts()) {
            Product product = productRepository.getReferenceById(productDto.getId());
            entity.getProducts().add(product);
        }
    }

}