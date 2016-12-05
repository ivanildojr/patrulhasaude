package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ServidorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Servidor.list(params), model:[servidorCount: Servidor.count()]
    }

    def show(Servidor servidor) {
        respond servidor
    }

    def create() {
        respond new Servidor(params)
    }

    @Transactional
    def save(Servidor servidor) {
        if (servidor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (servidor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond servidor.errors, view:'create'
            return
        }

        servidor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'servidor.label', default: 'Servidor'), servidor.id])
                redirect servidor
            }
            '*' { respond servidor, [status: CREATED] }
        }
    }

    def edit(Servidor servidor) {
        respond servidor
    }

    @Transactional
    def update(Servidor servidor) {
        if (servidor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (servidor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond servidor.errors, view:'edit'
            return
        }

        servidor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'servidor.label', default: 'Servidor'), servidor.id])
                redirect servidor
            }
            '*'{ respond servidor, [status: OK] }
        }
    }

    @Transactional
    def delete(Servidor servidor) {

        if (servidor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        servidor.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'servidor.label', default: 'Servidor'), servidor.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'servidor.label', default: 'Servidor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
