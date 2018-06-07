package org.metropolitan.it381.com

import grails.gorm.services.Service

@Service(Kategorija)
interface KategorijaService {

    Kategorija get(Serializable id)

    List<Kategorija> list(Map args)

    Long count()

    void delete(Serializable id)

    Kategorija save(Kategorija kategorija)

}