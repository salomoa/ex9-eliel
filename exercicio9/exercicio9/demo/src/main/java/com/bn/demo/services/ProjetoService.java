package com.bn.demo.services;

import com.bn.demo.models.ProjetoModel;
import com.bn.demo.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){
        return  projetoRepository.findAll();
    }

    public ProjetoModel criarPessoa(ProjetoModel projetoModel){
        return  projetoRepository.save(projetoModel);
    }

    public Optional<ProjetoModel> buscarid(Long id){
        return  projetoRepository.findById(id);
    }

    public ProjetoModel atualizar(Long id, ProjetoModel projetoModel){
        ProjetoModel model = projetoRepository.findById(id).get();
        model.setDataInicio(projetoModel.getDataInicio());
        model.setNome(projetoModel.getNome());
        model.setDataFim(projetoModel.getDataFim());
        return projetoRepository.save(model);
    }

    public void deletar(Long id){
        projetoRepository.deleteById(id);
    }

}
