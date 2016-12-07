package patrulhasaude

import grails.test.mixin.*
import spock.lang.*

@TestFor(AtividadesFisicasController)
@Mock(AtividadesFisicas)
class AtividadesFisicasControllerSpec extends Specification {

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
            !model.atividadesFisicasList
            model.atividadesFisicasCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.atividadesFisicas!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def atividadesFisicas = new AtividadesFisicas()
            atividadesFisicas.validate()
            controller.save(atividadesFisicas)

        then:"The create view is rendered again with the correct model"
            model.atividadesFisicas!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            atividadesFisicas = new AtividadesFisicas(params)

            controller.save(atividadesFisicas)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/atividadesFisicas/show/1'
            controller.flash.message != null
            AtividadesFisicas.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def atividadesFisicas = new AtividadesFisicas(params)
            controller.show(atividadesFisicas)

        then:"A model is populated containing the domain instance"
            model.atividadesFisicas == atividadesFisicas
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def atividadesFisicas = new AtividadesFisicas(params)
            controller.edit(atividadesFisicas)

        then:"A model is populated containing the domain instance"
            model.atividadesFisicas == atividadesFisicas
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/atividadesFisicas/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def atividadesFisicas = new AtividadesFisicas()
            atividadesFisicas.validate()
            controller.update(atividadesFisicas)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.atividadesFisicas == atividadesFisicas

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            atividadesFisicas = new AtividadesFisicas(params).save(flush: true)
            controller.update(atividadesFisicas)

        then:"A redirect is issued to the show action"
            atividadesFisicas != null
            response.redirectedUrl == "/atividadesFisicas/show/$atividadesFisicas.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/atividadesFisicas/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def atividadesFisicas = new AtividadesFisicas(params).save(flush: true)

        then:"It exists"
            AtividadesFisicas.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(atividadesFisicas)

        then:"The instance is deleted"
            AtividadesFisicas.count() == 0
            response.redirectedUrl == '/atividadesFisicas/index'
            flash.message != null
    }
}
