package com.metropolitan.dz14

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RokServiceSpec extends Specification {

    RokService rokService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rok(...).save(flush: true, failOnError: true)
        //new Rok(...).save(flush: true, failOnError: true)
        //Rok rok = new Rok(...).save(flush: true, failOnError: true)
        //new Rok(...).save(flush: true, failOnError: true)
        //new Rok(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rok.id
    }

    void "test get"() {
        setupData()

        expect:
        rokService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rok> rokList = rokService.list(max: 2, offset: 2)

        then:
        rokList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rokService.count() == 5
    }

    void "test delete"() {
        Long rokId = setupData()

        expect:
        rokService.count() == 5

        when:
        rokService.delete(rokId)
        sessionFactory.currentSession.flush()

        then:
        rokService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rok rok = new Rok()
        rokService.save(rok)

        then:
        rok.id != null
    }
}
