package patrulhasaude

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MedicamentosUsoContinuoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MedicamentosUsoContinuo.list(params), model:[medicamentosUsoContinuoCount: MedicamentosUsoContinuo.count()]
    }

    def show(MedicamentosUsoContinuo medicamentosUsoContinuo) {
        respond medicamentosUsoContinuo
    }

    def create() {
        respond new MedicamentosUsoContinuo(params)
    }

    @Transactional
    def save(MedicamentosUsoContinuo medicamentosUsoContinuo) {
        if (medicamentosUsoContinuo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medicamentosUsoContinuo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medicamentosUsoContinuo.errors, view:'create'
            return
        }

        medicamentosUsoContinuo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medicamentosUsoContinuo.label', default: 'MedicamentosUsoContinuo'), medicamentosUsoContinuo.id])
                redirect medicamentosUsoContinuo
            }
            '*' { respond medicamentosUsoContinuo, [status: CREATED] }
        }
    }

    def edit(MedicamentosUsoContinuo medicamentosUsoContinuo) {
        respond medicamentosUsoContinuo
    }

    @Transactional
    def update(MedicamentosUsoContinuo medicamentosUsoContinuo) {
        if (medicamentosUsoContinuo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medicamentosUsoContinuo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medicamentosUsoContinuo.errors, view:'edit'
            return
        }

        medicamentosUsoContinuo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medicamentosUsoContinuo.label', default: 'MedicamentosUsoContinuo'), medicamentosUsoContinuo.id])
                redirect medicamentosUsoContinuo
            }
            '*'{ respond medicamentosUsoContinuo, [status: OK] }
        }
    }

    @Transactional
    def delete(MedicamentosUsoContinuo medicamentosUsoContinuo) {

        if (medicamentosUsoContinuo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        medicamentosUsoContinuo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medicamentosUsoContinuo.label', default: 'MedicamentosUsoContinuo'), medicamentosUsoContinuo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medicamentosUsoContinuo.label', default: 'MedicamentosUsoContinuo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
