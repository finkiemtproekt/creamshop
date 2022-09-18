package com.ukim.mk.projectspring.Service;

import com.ukim.mk.projectspring.model.Cream;

import java.util.List;
import java.util.Optional;

public interface CreamService {

    List<Cream> findAll();

    Optional<Cream> findById(Integer id);

    Optional<Cream> findByName(String name);

    public Optional<Cream> save(Integer id, String name, String year, Integer firmId);

    //Optional<Books> save(ProductDto productDto);

    //Optional<Books> edit(Integer id, String name, Double price, Integer quantity, Long category, Long manufacturer);

    //Optional<Books> edit(Long id, ProductDto productDto);

    void deleteById(Integer id);
    void refreshMaterializedView();
    //Optional<Cream> save(BooksDto productDto);
}
