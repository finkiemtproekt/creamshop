package com.ukim.mk.projectspring.Service.impl;

import com.ukim.mk.projectspring.Service.CreamService;
import com.ukim.mk.projectspring.model.Cream;
import com.ukim.mk.projectspring.model.Firm;
import com.ukim.mk.projectspring.repo.CreamRepository;
import com.ukim.mk.projectspring.repo.FirmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreamServiceImpl implements CreamService {

    private final CreamRepository creamRepository;
    private final FirmRepository firmRepository;

    public CreamServiceImpl(CreamRepository creamRepository, FirmRepository firmRepository) {
        this.creamRepository = creamRepository;
        this.firmRepository = firmRepository;
    }

    @Override
    public List<Cream> findAll() {
        return this.creamRepository.findAll();
    }

    @Override
    public Optional<Cream> findById(Integer id) {
        return this.creamRepository.findById(id);
    }

    @Override
    public Optional<Cream> findByName(String name) {
        return this.creamRepository.findByName(name);
    }

    @Override
    public Optional<Cream> save(Integer id, String name, String year, Integer firmId) {
        Firm firm = this.firmRepository.findById(firmId).get();
        Cream cream = new Cream(id,name,year,firm);
        this.creamRepository.save(cream);
        return Optional.of(cream);
    }

    @Override
    public void deleteById(Integer id) {
    Cream cream = this.creamRepository.findById(id).get();
    this.creamRepository.delete(cream);
    }

    @Override
    public void refreshMaterializedView() {

    }
}
