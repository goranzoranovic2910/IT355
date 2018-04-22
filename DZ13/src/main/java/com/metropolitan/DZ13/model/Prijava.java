/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Goran
 */
@Entity
@Table(name="prijava")
public class Prijava {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRIJAVAID")
    private int prijavaId;
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ISPITID")
    private Ispit ispit;
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "STUDENTID")
    private User student;
    
    @Column(name="VREMEPRIJAVE")
    private Date vremePrijave;
    
    @Transient
    private int idIspita;

    /**
     * @return the prijavaId
     */
    public int getPrijavaId() {
        return prijavaId;
    }

    /**
     * @param prijavaId the prijavaId to set
     */
    public void setPrijavaId(int prijavaId) {
        this.prijavaId = prijavaId;
    }

    /**
     * @return the ispit
     */
    public Ispit getIspit() {
        return ispit;
    }

    /**
     * @param ispit the ispit to set
     */
    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    /**
     * @return the student
     */
    public User getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     * @return the vremePrijave
     */
    public Date getVremePrijave() {
        return vremePrijave;
    }

    /**
     * @param vremePrijave the vremePrijave to set
     */
    public void setVremePrijave(Date vremePrijave) {
        this.vremePrijave = vremePrijave;
    }

    /**
     * @return the idIspita
     */
    public int getIdIspita() {
        return idIspita;
    }

    /**
     * @param idIspita the idIspita to set
     */
    public void setIdIspita(int idIspita) {
        this.idIspita = idIspita;
    }
}
