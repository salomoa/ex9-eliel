package com.bn.demo.controllers;

import com.bn.demo.models.ProjetoModel;
import com.bn.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/projetos", "/projetos/"})
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
        public ResponseEntity<List<ProjetoModel> > findAll(){
          List<ProjetoModel> requeste = projetoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <ProjetoModel> criarPessoa(@RequestBody ProjetoModel projetoModel){
        ProjetoModel requeste = projetoService.criarPessoa(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(projetoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<ProjetoModel> buscarId(@PathVariable Long id){
        return  projetoService.buscarid(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProjetoModel> atualizar(@PathVariable Long id, @RequestBody ProjetoModel ProjetoModel){
        ProjetoModel requeste = projetoService.atualizar(id, ProjetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(ProjetoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);

    }








}
