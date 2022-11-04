    package br.com.digitalhouse.services;

    import br.com.digitalhouse.dtos.CategoryForProductDto;
    import br.com.digitalhouse.dtos.CityForProductDto;
    import br.com.digitalhouse.dtos.FeatureDto;
    import br.com.digitalhouse.dtos.ProductDto;
    import br.com.digitalhouse.entities.Category;
    import br.com.digitalhouse.entities.City;
    import br.com.digitalhouse.entities.Feature;
    import br.com.digitalhouse.entities.Product;
    import br.com.digitalhouse.repositories.CategoryRepository;
    import br.com.digitalhouse.repositories.CityRepository;
    import br.com.digitalhouse.repositories.FeatureRepository;
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
    public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private FeatureRepository featureRepository;

        @Autowired
        private CityRepository cityRepository;

        // SearchAll
        @Transactional(readOnly = true)
        public List<ProductDto> searchAll() {
            try {
                List<Product> list = productRepository.findAll();
                return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
            } catch (EntityNotFoundException e) {
                throw new DatabaseCarException(
                        "Registros não encontrados!"
                );
            }
        }

        // SearchById
        @Transactional(readOnly = true)
        public ProductDto searchById(Integer id) {
            Optional<Product> object = productRepository.findById(id);
            Product entity = object.orElseThrow(() -> new EntityCarNotFoundException("Registro: " + id + " não encontrado!"));
            return new ProductDto(entity);
        }

        // Insert
        @Transactional
        public ProductDto insert(ProductDto dto) {
            Product entity = new Product();
            copyDtoForEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductDto(entity);
        }

        // Update
        @Transactional
        public ProductDto update(Integer id, ProductDto dto) {
            try {
                Product entity = productRepository.getReferenceById(id);
                copyDtoForEntity(dto, entity);
                entity = productRepository.save(entity);
                return new ProductDto(entity);
            } catch (EntityNotFoundException e) {
                throw new DatabaseCarException(
                        "Registro " + id + " não encontrado!"
                );
            }
        }

        // Delete
        public void delete(Integer id) {
            try {
                productRepository.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                throw new EntityCarNotFoundException(
                        "Exclusão não realizada! Registro " + id + " não encontrado!"
                );
            }
            catch (DataIntegrityViolationException e) {
                throw new DatabaseCarException(
                        "Violação de integridade: Registro " + id + " está em outro registro!"
                );
            }
        }

        private void copyDtoForEntity(ProductDto dto, Product entity) {
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());

            entity.getFeatures().clear();
            for (FeatureDto featureDto : dto.getFeatures()) {
                Feature feature = featureRepository.getReferenceById(featureDto.getId());
                entity.getFeatures().add(feature);
            }

            CategoryForProductDto categoryForProductDto = dto.getCategory();
            Category category = categoryRepository.getReferenceById(categoryForProductDto.getId());
            entity.setCategory(category);

            CityForProductDto cityForProductDto = dto.getCity();
            City city = cityRepository.getReferenceById(cityForProductDto.getId());
            entity.setCity(city);
        }

    }