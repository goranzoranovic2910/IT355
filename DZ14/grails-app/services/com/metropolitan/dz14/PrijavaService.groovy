package com.metropolitan.dz14

import grails.gorm.services.Service

@Service(Prijava)
interface PrijavaService {

    Prijava get(Serializable id)

    List<Prijava> list(Map args)

    Long count()

    void delete(Serializable id)

    Prijava save(Prijava prijava)

}