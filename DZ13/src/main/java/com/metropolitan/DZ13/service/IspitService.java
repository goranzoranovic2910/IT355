/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.service;

import com.metropolitan.DZ13.model.Ispit;
import com.metropolitan.DZ13.model.Prijava;
import java.util.List;

/**
 *
 * @author Goran
 */
public interface IspitService {
    
    List<Ispit> getAll();
    
    void apply(Prijava p);
    
    List<Prijava> getAllPrijave();
    
    void cancel(int prijavaId);
    
}
