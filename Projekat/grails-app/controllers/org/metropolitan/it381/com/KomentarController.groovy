package org.metropolitan.it381.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured;

@Secured(['ROLE_USER','ROLE_ADMIN'])
class KomentarController {

    KomentarService komentarService
    TemaService temaService
    UserService userService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond komentarService.list(params), model:[komentarCount: komentarService.count()]
    }

    def show(Long id) {
        respond komentarService.get(id)
    }

    def create() {
        def komentar = new Komentar(params)
        komentar.autor = springSecurityService.currentUser
        respond komentar
    }

    def save(Komentar komentar) {
        if (komentar == null) {
            notFound()
            return
        }

        try {
            komentarService.save(komentar)
        } catch (ValidationException e) {
            respond komentar.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.created.message', args: [message(code: 'komentar.label', default: 'Komentar'), komentar.id])
                redirect komentar
            }
            '*' { respond komentar, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond komentarService.get(id)
    }

    def update(Komentar komentar) {
        if (komentar == null) {
            notFound()
            return
        }

        try {
            komentarService.save(komentar)
        } catch (ValidationException e) {
            respond komentar.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'komentar.label', default: 'Komentar'), komentar.id])
                redirect komentar
            }
            '*'{ respond komentar, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        komentarService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'komentar.label', default: 'Komentar'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'komentar.label', default: 'Komentar'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
