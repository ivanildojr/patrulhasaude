package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AtividadesFisicasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AtividadesFisicas.list(params), model:[atividadesFisicasCount: AtividadesFisicas.count()]
    }

    def show(AtividadesFisicas atividadesFisicas) {
        respond atividadesFisicas
    }

    def create() {
        respond new AtividadesFisicas(params)
    }

    @Transactional
    def save(AtividadesFisicas atividadesFisicas) {
        if (atividadesFisicas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (atividadesFisicas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond atividadesFisicas.errors, view:'create'
            return
        }

        atividadesFisicas.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'atividadesFisicas.label', default: 'AtividadesFisicas'), atividadesFisicas.id])
                redirect atividadesFisicas
            }
            '*' { respond atividadesFisicas, [status: CREATED] }
        }
    }

    def edit(AtividadesFisicas atividadesFisicas) {
        respond atividadesFisicas
    }

    @Transactional
    def update(AtividadesFisicas atividadesFisicas) {
        if (atividadesFisicas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (atividadesFisicas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond atividadesFisicas.errors, view:'edit'
            return
        }

        atividadesFisicas.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'atividadesFisicas.label', default: 'AtividadesFisicas'), atividadesFisicas.id])
                redirect atividadesFisicas
            }
            '*'{ respond atividadesFisicas, [status: OK] }
        }
    }

    @Transactional
    def delete(AtividadesFisicas atividadesFisicas) {

        if (atividadesFisicas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        atividadesFisicas.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'atividadesFisicas.label', default: 'AtividadesFisicas'), atividadesFisicas.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'atividadesFisicas.label', default: 'AtividadesFisicas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
