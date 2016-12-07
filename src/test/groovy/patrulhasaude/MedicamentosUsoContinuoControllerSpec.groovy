package patrulhasaude

import grails.test.mixin.*
import spock.lang.*

@TestFor(MedicamentosUsoContinuoController)
@Mock(MedicamentosUsoContinuo)
class MedicamentosUsoContinuoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.medicamentosUsoContinuoList
            model.medicamentosUsoContinuoCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.medicamentosUsoContinuo!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def medicamentosUsoContinuo = new MedicamentosUsoContinuo()
            medicamentosUsoContinuo.validate()
            controller.save(medicamentosUsoContinuo)

        then:"The create view is rendered again with the correct model"
            model.medicamentosUsoContinuo!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            medicamentosUsoContinuo = new MedicamentosUsoContinuo(params)

            controller.save(medicamentosUsoContinuo)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/medicamentosUsoContinuo/show/1'
            controller.flash.message != null
            MedicamentosUsoContinuo.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def medicamentosUsoContinuo = new MedicamentosUsoContinuo(params)
            controller.show(medicamentosUsoContinuo)

        then:"A model is populated containing the domain instance"
            model.medicamentosUsoContinuo == medicamentosUsoContinuo
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def medicamentosUsoContinuo = new MedicamentosUsoContinuo(params)
            controller.edit(medicamentosUsoContinuo)

        then:"A model is populated containing the domain instance"
            model.medicamentosUsoContinuo == medicamentosUsoContinuo
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/medicamentosUsoContinuo/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def medicamentosUsoContinuo = new MedicamentosUsoContinuo()
            medicamentosUsoContinuo.validate()
            controller.update(medicamentosUsoContinuo)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.medicamentosUsoContinuo == medicamentosUsoContinuo

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            medicamentosUsoContinuo = new MedicamentosUsoContinuo(params).save(flush: true)
            controller.update(medicamentosUsoContinuo)

        then:"A redirect is issued to the show action"
            medicamentosUsoContinuo != null
            response.redirectedUrl == "/medicamentosUsoContinuo/show/$medicamentosUsoContinuo.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/medicamentosUsoContinuo/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def medicamentosUsoContinuo = new MedicamentosUsoContinuo(params).save(flush: true)

        then:"It exists"
            MedicamentosUsoContinuo.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(medicamentosUsoContinuo)

        then:"The instance is deleted"
            MedicamentosUsoContinuo.count() == 0
            response.redirectedUrl == '/medicamentosUsoContinuo/index'
            flash.message != null
    }
}
