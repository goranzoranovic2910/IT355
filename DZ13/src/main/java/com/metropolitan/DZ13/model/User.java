/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;



/**
 *
 * @author Goran
 */
@Table
@Entity(name="student")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private int id;
    
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    
    @Column(name = "ime")
    @NotEmpty(message = "*Unesite ime")
    private String ime;
    
    @Column(name = "prezime")
    @NotEmpty(message = "*Unesite prezime")
    private String prezime;
    
    @Column(name = "active")
    private int active;
    
    @Column(name = "godiste")
    private int godiste;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_role", joinColumns = @JoinColumn(name = "STUDENTID"), inverseJoinColumns = @JoinColumn(name = "ROLEID"))
    private Set<Role> roles;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the godiste
     */
    public int getGodiste() {
        return godiste;
    }

    /**
     * @param godiste the godiste to set
     */
    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    /**
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
