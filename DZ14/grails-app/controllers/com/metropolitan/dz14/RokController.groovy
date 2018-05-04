package com.metropolitan.dz14

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RokController {

    RokService rokService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rokService.list(params), model:[rokCount: rokService.count()]
    }

    def show(Long id) {
        respond rokService.get(id)
    }

    def create() {
        respond new Rok(params)
    }

    def save(Rok rok) {
        if (rok == null) {
            notFound()
            return
        }

        try {
            rokService.save(rok)
        } catch (ValidationException e) {
            respond rok.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rok.label', default: 'Rok'), rok.id])
                redirect rok
            }
            '*' { respond rok, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rokService.get(id)
    }

    def update(Rok rok) {
        if (rok == null) {
            notFound()
            return
        }

        try {
            rokService.save(rok)
        } catch (ValidationException e) {
            respond rok.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rok.label', default: 'Rok'), rok.id])
                redirect rok
            }
            '*'{ respond rok, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rokService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rok.label', default: 'Rok'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rok.label', default: 'Rok'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
