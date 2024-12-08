package com.project.loteria.megasena.service;

import com.project.loteria.megasena.entities.MSBet;
import com.project.loteria.megasena.entities.MSPool;
import com.project.loteria.megasena.entities.MSResult;
import com.project.loteria.megasena.repositories.MSPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MSPoolService {
    @Autowired
    private MSPoolRepository repository;

    public MSPool creatPool(){
        MSPool pool = new MSPool();
        return repository.save(pool);
    }

    public MSPool findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pool not found with id "+ id));
    }

    public void addBetToPool(MSPool pool, MSBet bet){
        pool.getBets().add(bet);
        repository.save(pool);
    }

    public void addResultToPool(MSPool pool, MSResult result){
        pool.getResults().add(result);
        repository.save(pool);
    }

    public Double getValueTotal(Long id){
        MSPool pool = findById(id);
        return pool.getBets().stream().mapToDouble(MSBet::getValueInvested).sum();
    }
}
