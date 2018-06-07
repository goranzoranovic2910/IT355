package org.metropolitan.it381.com

class Komentar {

    static constraints = {
    }
    static belongsTo = [tema: Tema]
    static hasOne = [autor:User]
    String tekst
}
