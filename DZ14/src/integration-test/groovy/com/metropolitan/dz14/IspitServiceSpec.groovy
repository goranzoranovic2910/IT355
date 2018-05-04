package com.metropolitan.dz14

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IspitServiceSpec extends Specification {

    IspitService ispitService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ispit(...).save(flush: true, failOnError: true)
        //new Ispit(...).save(flush: true, failOnError: true)
        //Ispit ispit = new Ispit(...).save(flush: true, failOnError: true)
        //new Ispit(...).save(flush: true, failOnError: true)
        //new Ispit(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ispit.id
    }

    void "test get"() {
        setupData()

        expect:
        ispitService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ispit> ispitList = ispitService.list(max: 2, offset: 2)

        then:
        ispitList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ispitService.count() == 5
    }

    void "test delete"() {
        Long ispitId = setupData()

        expect:
        ispitService.count() == 5

        when:
        ispitService.delete(ispitId)
        sessionFactory.currentSession.flush()

        then:
        ispitService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ispit ispit = new Ispit()
        ispitService.save(ispit)

        then:
        ispit.id != null
    }
}
