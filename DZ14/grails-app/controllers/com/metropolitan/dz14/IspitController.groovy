package com.metropolitan.dz14

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IspitController {

    IspitService ispitService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ispitService.list(params), model:[ispitCount: ispitService.count()]
    }

    def show(Long id) {
        respond ispitService.get(id)
    }

    def create() {
        respond new Ispit(params)
    }

    def save(Ispit ispit) {
        if (ispit == null) {
            notFound()
            return
        }

        try {
            ispitService.save(ispit)
        } catch (ValidationException e) {
            respond ispit.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ispit.label', default: 'Ispit'), ispit.id])
                redirect ispit
            }
            '*' { respond ispit, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ispitService.get(id)
    }

    def update(Ispit ispit) {
        if (ispit == null) {
            notFound()
            return
        }

        try {
            ispitService.save(ispit)
        } catch (ValidationException e) {
            respond ispit.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ispit.label', default: 'Ispit'), ispit.id])
                redirect ispit
            }
            '*'{ respond ispit, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ispitService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ispit.label', default: 'Ispit'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ispit.label', default: 'Ispit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
