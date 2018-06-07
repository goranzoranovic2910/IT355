package org.metropolitan.it381.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class KomentarServiceSpec extends Specification {

    KomentarService komentarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Komentar(...).save(flush: true, failOnError: true)
        //new Komentar(...).save(flush: true, failOnError: true)
        //Komentar komentar = new Komentar(...).save(flush: true, failOnError: true)
        //new Komentar(...).save(flush: true, failOnError: true)
        //new Komentar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //komentar.id
    }

    void "test get"() {
        setupData()

        expect:
        komentarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Komentar> komentarList = komentarService.list(max: 2, offset: 2)

        then:
        komentarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        komentarService.count() == 5
    }

    void "test delete"() {
        Long komentarId = setupData()

        expect:
        komentarService.count() == 5

        when:
        komentarService.delete(komentarId)
        sessionFactory.currentSession.flush()

        then:
        komentarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Komentar komentar = new Komentar()
        komentarService.save(komentar)

        then:
        komentar.id != null
    }
}
