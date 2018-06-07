package org.metropolitan.it381.com

import grails.gorm.services.Service

@Service(Komentar)
interface KomentarService {

    Komentar get(Serializable id)

    List<Komentar> list(Map args)

    Long count()

    void delete(Serializable id)

    Komentar save(Komentar komentar)

}