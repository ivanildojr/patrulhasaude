package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrientacoesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Orientacoes.list(params), model:[orientacoesCount: Orientacoes.count()]
    }

    def show(Orientacoes orientacoes) {
        respond orientacoes
    }

    def create() {
        respond new Orientacoes(params)
    }

    @Transactional
    def save(Orientacoes orientacoes) {
        if (orientacoes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orientacoes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orientacoes.errors, view:'create'
            return
        }

        orientacoes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orientacoes.label', default: 'Orientacoes'), orientacoes.id])
                redirect orientacoes
            }
            '*' { respond orientacoes, [status: CREATED] }
        }
    }

    def edit(Orientacoes orientacoes) {
        respond orientacoes
    }

    @Transactional
    def update(Orientacoes orientacoes) {
        if (orientacoes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orientacoes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orientacoes.errors, view:'edit'
            return
        }

        orientacoes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orientacoes.label', default: 'Orientacoes'), orientacoes.id])
                redirect orientacoes
            }
            '*'{ respond orientacoes, [status: OK] }
        }
    }

    @Transactional
    def delete(Orientacoes orientacoes) {

        if (orientacoes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        orientacoes.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orientacoes.label', default: 'Orientacoes'), orientacoes.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orientacoes.label', default: 'Orientacoes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
