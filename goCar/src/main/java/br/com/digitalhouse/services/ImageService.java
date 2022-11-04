package br.com.digitalhouse.services;

import br.com.digitalhouse.dtos.ImageDto;
import br.com.digitalhouse.entities.Image;
import br.com.digitalhouse.repositories.ImageRepository;
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
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    // SearchAll
    @Transactional(readOnly = true)
    public List<ImageDto> searchAll() {
        try {
            List<Image> list = imageRepository.findAll();
            return list.stream().map(x -> new ImageDto(x)).collect(Collectors.toList());
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registros não encontrados!"
            );
        }
    }

    // SearchById
    @Transactional(readOnly = true)
    public ImageDto searchById(Integer id) {
        Optional<Image> object = imageRepository.findById(id);
        Image entity = object.orElseThrow(() -> new EntityCarNotFoundException("Registro: " + id + " não encontrado!"));
        return new ImageDto(entity);
    }

    // Insert
    @Transactional
    public ImageDto insert(ImageDto dto) {
        Image entity = new Image();
        copyDtoForEntity(dto, entity);
        entity = imageRepository.save(entity);
        return new ImageDto(entity);
    }

    // Update
    @Transactional
    public ImageDto update(Integer id, ImageDto dto) {
        try {
            Image entity = imageRepository.getReferenceById(id);
            copyDtoForEntity(dto, entity);
            entity = imageRepository.save(entity);
            return new ImageDto(entity);
        } catch (EntityNotFoundException e) {
            throw new DatabaseCarException(
                    "Registro " + id + " não encontrado!"
            );
        }
    }

    // Delete
    public void delete(Integer id) {
        try {
            imageRepository.deleteById(id);
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

    private void copyDtoForEntity(ImageDto dto, Image entity) {
        entity.setTitle(dto.getTitle());
        entity.setUrlImage(dto.getUrlImage());
    }

}