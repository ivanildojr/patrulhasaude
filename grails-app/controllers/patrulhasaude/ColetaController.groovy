package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ColetaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Coleta.list(params), model:[coletaCount: Coleta.count()]
    }

    def show(Coleta coleta) {
        respond coleta
    }

    def create() {
        respond new Coleta(params)
    }

    @Transactional
    def save(Coleta coleta) {
        if (coleta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (coleta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond coleta.errors, view:'create'
            return
        }

        coleta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coleta.label', default: 'Coleta'), coleta.id])
                redirect coleta
            }
            '*' { respond coleta, [status: CREATED] }
        }
    }

    def edit(Coleta coleta) {
        respond coleta
    }

    @Transactional
    def update(Coleta coleta) {
        if (coleta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (coleta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond coleta.errors, view:'edit'
            return
        }

        coleta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'coleta.label', default: 'Coleta'), coleta.id])
                redirect coleta
            }
            '*'{ respond coleta, [status: OK] }
        }
    }

    @Transactional
    def delete(Coleta coleta) {

        if (coleta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        coleta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'coleta.label', default: 'Coleta'), coleta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coleta.label', default: 'Coleta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
