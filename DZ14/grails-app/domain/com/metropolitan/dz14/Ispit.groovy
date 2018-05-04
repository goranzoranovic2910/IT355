package com.metropolitan.dz14
import grails.persistence.*

@Entity
class Ispit {
   Predmet predmet

    static mapping = {
        predmet cascade:'save-update'
        rok cascade:'save-update'
    }
    String naziv
    Date vreme
    Rok rok
    
}
