package br.com.digitalhouse.services;

import br.com.digitalhouse.dtos.CategoryDto;
import br.com.digitalhouse.dtos.ProductDto;
import br.com.digitalhouse.entities.Category;
import br.com.digitalhouse.entities.Product;
import br.com.digitalhouse.repositories.CategoryRepository;
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
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // SearchAll
    @Transactional(readOnly = true)
    public List<CategoryDto> searchAll() {
        try {
            List<Category> list = categoryRepository.findAll();
            return list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registros não encontrados!"
            );
        }
    }

    // SearchById
    @Transactional(readOnly = true)
    public CategoryDto searchById(Integer id) {
        Optional<Category> object = categoryRepository.findById(id);
        Category entity = object.orElseThrow(() -> new EntityCarNotFoundException("Registro: " + id + " não encontrado!"));
        return new CategoryDto(entity);
    }

    // Insert
    @Transactional
    public CategoryDto insert(CategoryDto dto) {
        Category entity = new Category();
        copyDtoForEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    // Update
    @Transactional
    public CategoryDto update(Integer id, CategoryDto dto) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            copyDtoForEntity(dto, entity);
            entity = categoryRepository.save(entity);
            return new CategoryDto(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registro " + id + " não encontrado!"
            );
        }
    }

    // Delete
    public void delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
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

    private void copyDtoForEntity(CategoryDto dto, Category entity) {
        entity.setQualification(dto.getQualification());
        entity.setDescription(dto.getDescription());
        entity.setUrlImage(dto.getUrlImage());

        entity.getProducts().clear();
        for (ProductDto productDto : dto.getProducts()) {
            Product product = productRepository.getReferenceById(productDto.getId());
            entity.getProducts().add(product);
        }
    }

}