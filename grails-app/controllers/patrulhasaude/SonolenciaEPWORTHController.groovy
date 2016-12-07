package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SonolenciaEPWORTHController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SonolenciaEPWORTH.list(params), model:[sonolenciaEPWORTHCount: SonolenciaEPWORTH.count()]
    }

    def show(SonolenciaEPWORTH sonolenciaEPWORTH) {
        respond sonolenciaEPWORTH
    }

    def create() {
        respond new SonolenciaEPWORTH(params)
    }

    @Transactional
    def save(SonolenciaEPWORTH sonolenciaEPWORTH) {
        if (sonolenciaEPWORTH == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sonolenciaEPWORTH.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sonolenciaEPWORTH.errors, view:'create'
            return
        }

        sonolenciaEPWORTH.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sonolenciaEPWORTH.label', default: 'SonolenciaEPWORTH'), sonolenciaEPWORTH.id])
                redirect sonolenciaEPWORTH
            }
            '*' { respond sonolenciaEPWORTH, [status: CREATED] }
        }
    }

    def edit(SonolenciaEPWORTH sonolenciaEPWORTH) {
        respond sonolenciaEPWORTH
    }

    @Transactional
    def update(SonolenciaEPWORTH sonolenciaEPWORTH) {
        if (sonolenciaEPWORTH == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sonolenciaEPWORTH.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sonolenciaEPWORTH.errors, view:'edit'
            return
        }

        sonolenciaEPWORTH.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sonolenciaEPWORTH.label', default: 'SonolenciaEPWORTH'), sonolenciaEPWORTH.id])
                redirect sonolenciaEPWORTH
            }
            '*'{ respond sonolenciaEPWORTH, [status: OK] }
        }
    }

    @Transactional
    def delete(SonolenciaEPWORTH sonolenciaEPWORTH) {

        if (sonolenciaEPWORTH == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        sonolenciaEPWORTH.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sonolenciaEPWORTH.label', default: 'SonolenciaEPWORTH'), sonolenciaEPWORTH.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sonolenciaEPWORTH.label', default: 'SonolenciaEPWORTH'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
