package com.maher.section345.service;

import com.maher.section345.entities.Equipe;
import com.maher.section345.repos.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EquipeServieImpl implements EquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    @Override
    public Equipe saveEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Equipe e) {
        equipeRepository.delete(e);

    }

    @Override
    public void deleteEquipeById(Long id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe getEquipe(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Page<Equipe> getAllEquipesParPage(int page, int size) {
        return equipeRepository.findAll(PageRequest.of(page, size));
    }
}
