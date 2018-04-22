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

/**
 *
 * @author Goran
 */
@Entity
@Table(name="ispit")
public class Ispit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ISPITID")
    private int ispitId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PREDMETID")
    private Predmet predmet;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROKID")
    private Rok rok;
    
    @Column(name="VREME")
    private Date vreme;

    /**
     * @return the ispitId
     */
    public int getIspitId() {
        return ispitId;
    }

    /**
     * @param ispitId the ispitId to set
     */
    public void setIspitId(int ispitId) {
        this.ispitId = ispitId;
    }

    /**
     * @return the predmet
     */
    public Predmet getPredmet() {
        return predmet;
    }

    /**
     * @param predmet the predmet to set
     */
    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    /**
     * @return the rok
     */
    public Rok getRok() {
        return rok;
    }

    /**
     * @param rok the rok to set
     */
    public void setRok(Rok rok) {
        this.rok = rok;
    }

    /**
     * @return the vreme
     */
    public Date getVreme() {
        return vreme;
    }

    /**
     * @param vreme the vreme to set
     */
    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }
}
