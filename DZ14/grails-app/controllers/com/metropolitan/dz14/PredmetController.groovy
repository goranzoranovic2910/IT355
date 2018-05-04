package com.metropolitan.dz14

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PredmetController {

    PredmetService predmetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond predmetService.list(params), model:[predmetCount: predmetService.count()]
    }

    def show(Long id) {
        respond predmetService.get(id)
    }

    def create() {
        respond new Predmet(params)
    }

    def save(Predmet predmet) {
        if (predmet == null) {
            notFound()
            return
        }

        try {
            predmetService.save(predmet)
        } catch (ValidationException e) {
            respond predmet.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'predmet.label', default: 'Predmet'), predmet.id])
                redirect predmet
            }
            '*' { respond predmet, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond predmetService.get(id)
    }

    def update(Predmet predmet) {
        if (predmet == null) {
            notFound()
            return
        }

        try {
            predmetService.save(predmet)
        } catch (ValidationException e) {
            respond predmet.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'predmet.label', default: 'Predmet'), predmet.id])
                redirect predmet
            }
            '*'{ respond predmet, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        predmetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'predmet.label', default: 'Predmet'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'predmet.label', default: 'Predmet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
