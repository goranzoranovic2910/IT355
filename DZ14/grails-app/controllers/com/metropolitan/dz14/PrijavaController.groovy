package com.metropolitan.dz14

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PrijavaController {

    PrijavaService prijavaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond prijavaService.list(params), model:[prijavaCount: prijavaService.count()]
    }

    def show(Long id) {
        respond prijavaService.get(id)
    }

    def create() {
        respond new Prijava(params)
    }

    def save(Prijava prijava) {
        if (prijava == null) {
            notFound()
            return
        }

        try {
            prijavaService.save(prijava)
        } catch (ValidationException e) {
            respond prijava.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'prijava.label', default: 'Prijava'), prijava.id])
                redirect prijava
            }
            '*' { respond prijava, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond prijavaService.get(id)
    }

    def update(Prijava prijava) {
        if (prijava == null) {
            notFound()
            return
        }

        try {
            prijavaService.save(prijava)
        } catch (ValidationException e) {
            respond prijava.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'prijava.label', default: 'Prijava'), prijava.id])
                redirect prijava
            }
            '*'{ respond prijava, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        prijavaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'prijava.label', default: 'Prijava'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'prijava.label', default: 'Prijava'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
