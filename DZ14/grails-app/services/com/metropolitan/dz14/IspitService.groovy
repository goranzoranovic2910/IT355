package com.metropolitan.dz14

import grails.gorm.services.Service

@Service(Ispit)
interface IspitService {

    Ispit get(Serializable id)

    List<Ispit> list(Map args)

    Long count()

    void delete(Serializable id)

    Ispit save(Ispit ispit)

}