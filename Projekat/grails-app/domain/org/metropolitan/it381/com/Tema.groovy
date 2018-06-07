package org.metropolitan.it381.com

class Tema {

    static constraints = {
    }

    static hasMany = [komentari: Komentar]
    static belongsTo = [kategorija: Kategorija]

    String naziv
    String opis
}
