package com.metropolitan.dz14

import grails.gorm.services.Service

@Service(Rok)
interface RokService {

    Rok get(Serializable id)

    List<Rok> list(Map args)

    Long count()

    void delete(Serializable id)

    Rok save(Rok rok)

}