package com.metropolitan.dz14
import grails.persistence.*
import java.util.Date

@Entity
class Rok {

    String naziv
    Date odDatuma;
    Date doDatuma;
}
