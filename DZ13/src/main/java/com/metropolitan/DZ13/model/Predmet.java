/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Goran
 */

@Entity
@Table(name="predmet")
public class Predmet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PREDMETID")
    private int predmetId;
    
    @Column(name="GODINA")
    private int godina;
    
    @Column(name="NAZIV")
    private String naziv;
    
    @Column(name="OPIS")
    private String opis;
    
    @Column(name="SIFRA")
    private String sifra;

    /**
     * @return the predmetId
     */
    public int getPredmetId() {
        return predmetId;
    }

    /**
     * @param predmetId the predmetId to set
     */
    public void setPredmetId(int predmetId) {
        this.predmetId = predmetId;
    }

    /**
     * @return the godina
     */
    public int getGodina() {
        return godina;
    }

    /**
     * @param godina the godina to set
     */
    public void setGodina(int godina) {
        this.godina = godina;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the sifra
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * @param sifra the sifra to set
     */
    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
}
