package org.metropolitan.it381.com

import grails.gorm.services.Service

@Service(Tema)
interface TemaService {

    Tema get(Serializable id)

    List<Tema> list(Map args)

    Long count()

    void delete(Serializable id)

    Tema save(Tema tema)

}