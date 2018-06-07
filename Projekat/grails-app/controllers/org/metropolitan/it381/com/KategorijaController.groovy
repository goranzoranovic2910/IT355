package org.metropolitan.it381.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured;

class KategorijaController {

    KategorijaService kategorijaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond kategorijaService.list(params), model:[kategorijaCount: kategorijaService.count()]
    }

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def show(Long id) {
        respond kategorijaService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Kategorija(params)
    }

    @Secured(['ROLE_ADMIN'])
    def save(Kategorija kategorija) {
        if (kategorija == null) {
            notFound()
            return
        }

        try {
            kategorijaService.save(kategorija)
        } catch (ValidationException e) {
            respond kategorija.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'kategorija.label', default: 'Kategorija'), kategorija.id])
                redirect kategorija
            }
            '*' { respond kategorija, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        respond kategorijaService.get(id)
    }

    @Secured(['ROLE_ADMIN'])
    def update(Kategorija kategorija) {
        if (kategorija == null) {
            notFound()
            return
        }

        try {
            kategorijaService.save(kategorija)
        } catch (ValidationException e) {
            respond kategorija.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'kategorija.label', default: 'Kategorija'), kategorija.id])
                redirect kategorija
            }
            '*'{ respond kategorija, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        kategorijaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'kategorija.label', default: 'Kategorija'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'kategorija.label', default: 'Kategorija'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
