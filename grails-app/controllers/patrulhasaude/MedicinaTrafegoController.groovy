package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MedicinaTrafegoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MedicinaTrafego.list(params), model:[medicinaTrafegoCount: MedicinaTrafego.count()]
    }

    def show(MedicinaTrafego medicinaTrafego) {
        respond medicinaTrafego
    }

    def create() {
        respond new MedicinaTrafego(params)
    }

    @Transactional
    def save(MedicinaTrafego medicinaTrafego) {
        if (medicinaTrafego == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medicinaTrafego.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medicinaTrafego.errors, view:'create'
            return
        }

        medicinaTrafego.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medicinaTrafego.label', default: 'MedicinaTrafego'), medicinaTrafego.id])
                redirect medicinaTrafego
            }
            '*' { respond medicinaTrafego, [status: CREATED] }
        }
    }

    def edit(MedicinaTrafego medicinaTrafego) {
        respond medicinaTrafego
    }

    @Transactional
    def update(MedicinaTrafego medicinaTrafego) {
        if (medicinaTrafego == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medicinaTrafego.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medicinaTrafego.errors, view:'edit'
            return
        }

        medicinaTrafego.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medicinaTrafego.label', default: 'MedicinaTrafego'), medicinaTrafego.id])
                redirect medicinaTrafego
            }
            '*'{ respond medicinaTrafego, [status: OK] }
        }
    }

    @Transactional
    def delete(MedicinaTrafego medicinaTrafego) {

        if (medicinaTrafego == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        medicinaTrafego.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicinaTrafego.label', default: 'MedicinaTrafego'), medicinaTrafego.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicinaTrafego.label', default: 'MedicinaTrafego'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
