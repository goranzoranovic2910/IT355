package com.metropolitan.dz14

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PrijavaServiceSpec extends Specification {

    PrijavaService prijavaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Prijava(...).save(flush: true, failOnError: true)
        //new Prijava(...).save(flush: true, failOnError: true)
        //Prijava prijava = new Prijava(...).save(flush: true, failOnError: true)
        //new Prijava(...).save(flush: true, failOnError: true)
        //new Prijava(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //prijava.id
    }

    void "test get"() {
        setupData()

        expect:
        prijavaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Prijava> prijavaList = prijavaService.list(max: 2, offset: 2)

        then:
        prijavaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        prijavaService.count() == 5
    }

    void "test delete"() {
        Long prijavaId = setupData()

        expect:
        prijavaService.count() == 5

        when:
        prijavaService.delete(prijavaId)
        sessionFactory.currentSession.flush()

        then:
        prijavaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Prijava prijava = new Prijava()
        prijavaService.save(prijava)

        then:
        prijava.id != null
    }
}
