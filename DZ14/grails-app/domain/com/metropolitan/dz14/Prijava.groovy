package com.metropolitan.dz14
import grails.persistence.*

@Entity
class Prijava {

    static constraints = {
    }

    Ispit ispit
    Student student

    static mapping = {
        ispit cascade:'save-update'
        student cascade:'save-update'
    }
}
