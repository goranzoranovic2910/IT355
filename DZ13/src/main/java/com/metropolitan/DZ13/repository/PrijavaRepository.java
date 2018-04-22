/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.repository;

import com.metropolitan.DZ13.model.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Goran
 */
public interface PrijavaRepository extends JpaRepository<Prijava,Integer> {
    
}
