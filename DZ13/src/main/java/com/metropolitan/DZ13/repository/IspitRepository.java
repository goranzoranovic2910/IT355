/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.repository;

import com.metropolitan.DZ13.model.Ispit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Goran
 */
@Repository("ispitRepository")
public interface IspitRepository extends JpaRepository<Ispit, Integer> {
}
