package org.metropolitan.it381.com

class Korisnik {

    static constraints = {
    }

    static hasMany = [komentari: Komentar]

    String ime
    String prezime
    String korisnickoIme
    String loznika
    Date blokiranOd
    Date blokiranDo
}
