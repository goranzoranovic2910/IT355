package org.metropolitan.it381.com

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured;

@Secured(['ROLE_USER','ROLE_ADMIN'])
class TemaController {

    TemaService temaService
    KategorijaService kategorijaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond temaService.list(params), model:[temaCount: temaService.count()]
    }

    def show(Long id) {
        respond temaService.get(id)
    }

    def create() {
        respond new Tema(params), model:[sveKategorije: kategorijaService.list()]
    }

    def save(Tema tema) {
        if (tema == null) {
            notFound()
            return
        }

        try {
            temaService.save(tema)
        } catch (ValidationException e) {
            respond tema.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tema.label', default: 'Tema'), tema.id])
                redirect tema
            }
            '*' { respond tema, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond temaService.get(id), model:[sveKategorije: kategorijaService.list()]
    }

    def update(Tema tema) {
        if (tema == null) {
            notFound()
            return
        }

        try {
            temaService.save(tema)
        } catch (ValidationException e) {
            respond tema.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tema.label', default: 'Tema'), tema.id])
                redirect tema
            }
            '*'{ respond tema, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        temaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tema.label', default: 'Tema'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tema.label', default: 'Tema'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
