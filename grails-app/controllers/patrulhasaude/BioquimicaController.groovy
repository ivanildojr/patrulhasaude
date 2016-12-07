package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BioquimicaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bioquimica.list(params), model:[bioquimicaCount: Bioquimica.count()]
    }

    def show(Bioquimica bioquimica) {
        respond bioquimica
    }

    def create() {
        respond new Bioquimica(params)
    }

    @Transactional
    def save(Bioquimica bioquimica) {
        if (bioquimica == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (bioquimica.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond bioquimica.errors, view:'create'
            return
        }

        bioquimica.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bioquimica.label', default: 'Bioquimica'), bioquimica.id])
                redirect bioquimica
            }
            '*' { respond bioquimica, [status: CREATED] }
        }
    }

    def edit(Bioquimica bioquimica) {
        respond bioquimica
    }

    @Transactional
    def update(Bioquimica bioquimica) {
        if (bioquimica == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (bioquimica.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond bioquimica.errors, view:'edit'
            return
        }

        bioquimica.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bioquimica.label', default: 'Bioquimica'), bioquimica.id])
                redirect bioquimica
            }
            '*'{ respond bioquimica, [status: OK] }
        }
    }

    @Transactional
    def delete(Bioquimica bioquimica) {

        if (bioquimica == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        bioquimica.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bioquimica.label', default: 'Bioquimica'), bioquimica.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bioquimica.label', default: 'Bioquimica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
