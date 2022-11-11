package com.example.noticiasback.services;

import com.example.noticiasback.entities.Noticia;
import com.example.noticiasback.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public void save(Noticia noticia){
        if(noticia != null)
            noticiaRepository.save(noticia);
    }

    public void delete(Integer id){
        noticiaRepository.deleteById(id);
    }

    public void update(Noticia noticia){
        Optional<Noticia> findNoticia = findById(noticia);
        if(findNoticia.isPresent())
            findNoticia.get().setDescription(noticia.getDescription());
            findNoticia.get().setTitle(noticia.getTitle());

    }

    public ResponseEntity<List<Noticia>> searchAll() {
        return ResponseEntity.ok(noticiaRepository.findAll());
    }

    private Optional<Noticia> findById(Noticia noticia){
        return noticiaRepository.findById(noticia.getId());
    }
}
