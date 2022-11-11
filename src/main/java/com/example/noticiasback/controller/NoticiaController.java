package com.example.noticiasback.controller;

import com.example.noticiasback.entities.Noticia;
import com.example.noticiasback.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoticiaController {


    @Autowired
    private NoticiaService noticiaService;


    @GetMapping
    public String getString(){
        return "Hello world";
    }


    @PostMapping("/criar")
    public ResponseEntity create(@RequestBody Noticia noticia){
        noticiaService.save(noticia);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/editar")
    public ResponseEntity update(@RequestBody Noticia noticia){
        noticiaService.update(noticia);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Integer id){
        noticiaService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/listar")
    public ResponseEntity<List<Noticia>> getAll(){
        return ResponseEntity.ok(noticiaService.searchAll().getBody());
    }

}
