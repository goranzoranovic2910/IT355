/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.model;

import java.util.Date;
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
@Table(name="rok")
public class Rok {
    
    @Column(name="ROKID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rokId;
    
    @Column(name="DATUMOD")
    private Date datumOd;
    
    @Column(name="DATUMDO")
    private Date datumDo;
    
    @Column(name="NAZIV")
    private String naziv;

    public int getRokId() {
        return rokId;
    }

    public void setRokId(int rokId) {
        this.rokId = rokId;
    }

    /**
     * @return the datumOd
     */
    public Date getDatumOd() {
        return datumOd;
    }

    /**
     * @param datumOd the datumOd to set
     */
    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    /**
     * @return the datumDo
     */
    public Date getDatumDo() {
        return datumDo;
    }

    /**
     * @param datumDo the datumDo to set
     */
    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
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
    
}
