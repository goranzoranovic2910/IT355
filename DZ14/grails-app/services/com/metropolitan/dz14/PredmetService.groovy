package com.metropolitan.dz14

import grails.gorm.services.Service

@Service(Predmet)
interface PredmetService {

    Predmet get(Serializable id)

    List<Predmet> list(Map args)

    Long count()

    void delete(Serializable id)

    Predmet save(Predmet predmet)

}