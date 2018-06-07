package org.metropolitan.it381.com

class Kategorija {

    static constraints = {
    }
    static hasMany = [teme: Tema]
    String naziv;
    String opis;
    
}
