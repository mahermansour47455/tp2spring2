package com.maher.section345.service;

import com.maher.section345.entities.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EquipeService {


    Equipe saveEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe(Equipe e);
    void deleteEquipeById(Long id);
    Equipe getEquipe(Long id);
    List<Equipe> getAllEquipes();
    Page<Equipe> getAllEquipesParPage(int page, int size);

}
