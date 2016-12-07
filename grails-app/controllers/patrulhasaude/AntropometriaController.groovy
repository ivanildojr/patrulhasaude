package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AntropometriaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Antropometria.list(params), model:[antropometriaCount: Antropometria.count()]
    }

    def show(Antropometria antropometria) {
        respond antropometria
    }

    def create() {
        respond new Antropometria(params)
    }

    @Transactional
    def save(Antropometria antropometria) {
        if (antropometria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (antropometria.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond antropometria.errors, view:'create'
            return
        }

        antropometria.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'antropometria.label', default: 'Antropometria'), antropometria.id])
                redirect antropometria
            }
            '*' { respond antropometria, [status: CREATED] }
        }
    }

    def edit(Antropometria antropometria) {
        respond antropometria
    }

    @Transactional
    def update(Antropometria antropometria) {
        if (antropometria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (antropometria.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond antropometria.errors, view:'edit'
            return
        }

        antropometria.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'antropometria.label', default: 'Antropometria'), antropometria.id])
                redirect antropometria
            }
            '*'{ respond antropometria, [status: OK] }
        }
    }

    @Transactional
    def delete(Antropometria antropometria) {

        if (antropometria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        antropometria.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'antropometria.label', default: 'Antropometria'), antropometria.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'antropometria.label', default: 'Antropometria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
