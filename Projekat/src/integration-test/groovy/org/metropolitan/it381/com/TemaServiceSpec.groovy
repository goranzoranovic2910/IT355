package org.metropolitan.it381.com

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TemaServiceSpec extends Specification {

    TemaService temaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tema(...).save(flush: true, failOnError: true)
        //new Tema(...).save(flush: true, failOnError: true)
        //Tema tema = new Tema(...).save(flush: true, failOnError: true)
        //new Tema(...).save(flush: true, failOnError: true)
        //new Tema(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tema.id
    }

    void "test get"() {
        setupData()

        expect:
        temaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tema> temaList = temaService.list(max: 2, offset: 2)

        then:
        temaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        temaService.count() == 5
    }

    void "test delete"() {
        Long temaId = setupData()

        expect:
        temaService.count() == 5

        when:
        temaService.delete(temaId)
        sessionFactory.currentSession.flush()

        then:
        temaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tema tema = new Tema()
        temaService.save(tema)

        then:
        tema.id != null
    }
}
