/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.service;

import com.metropolitan.DZ13.model.Ispit;
import com.metropolitan.DZ13.model.Prijava;
import com.metropolitan.DZ13.repository.IspitRepository;
import com.metropolitan.DZ13.repository.PrijavaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Goran
 */
@Service("ispitService")
public class IspitServiceImpl implements IspitService {
    
    @Autowired
    private IspitRepository ispitRepository;
    
    @Autowired
    private PrijavaRepository prijavaRepository;

    @Override
    public List<Ispit> getAll() {
        return this.ispitRepository.findAll();
    }

    @Override
    public void apply(Prijava p) {
        this.prijavaRepository.save(p);
    }
    
    @Override
    public List<Prijava> getAllPrijave(){
       return this.prijavaRepository.findAll();
    }

    @Override
    public void cancel(int prijavaId) {
        this.prijavaRepository.delete(this.prijavaRepository.findById(prijavaId).get());
    }
    
}
