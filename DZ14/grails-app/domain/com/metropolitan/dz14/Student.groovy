package com.metropolitan.dz14

import grails.persistence.*

@Entity
class Student {

    static constraints = {
    }

    String username;
    String password;
    String name;
    String lastName;
}
