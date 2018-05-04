package com.metropolitan.dz14

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PredmetServiceSpec extends Specification {

    PredmetService predmetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Predmet(...).save(flush: true, failOnError: true)
        //new Predmet(...).save(flush: true, failOnError: true)
        //Predmet predmet = new Predmet(...).save(flush: true, failOnError: true)
        //new Predmet(...).save(flush: true, failOnError: true)
        //new Predmet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //predmet.id
    }

    void "test get"() {
        setupData()

        expect:
        predmetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Predmet> predmetList = predmetService.list(max: 2, offset: 2)

        then:
        predmetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        predmetService.count() == 5
    }

    void "test delete"() {
        Long predmetId = setupData()

        expect:
        predmetService.count() == 5

        when:
        predmetService.delete(predmetId)
        sessionFactory.currentSession.flush()

        then:
        predmetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Predmet predmet = new Predmet()
        predmetService.save(predmet)

        then:
        predmet.id != null
    }
}
