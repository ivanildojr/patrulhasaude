<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'coleta.label', default: 'Coleta')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:javascript src="jquery-2.2.0.min.js"/>
    </head>
    <body>
        <a href="#create-coleta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-coleta" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.coleta}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.coleta}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save" >
                <fieldset class="form" id="formColeta">
                    <f:all bean="coleta" except="frequenciaConsumo,dosePorVez,classificacaoEtilismo"/>
                    <f:field property="frequenciaConsumo" bean="coleta"/>
                    <f:field property="dosePorVez" bean="coleta" ></f:field>
                    <f:field property="classificacaoEtilismo" bean="coleta"></f:field>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
        <g:javascript>
              $('#classificacaoEtilismo').prop('disabled', true);
              $('#frequenciaConsumo').on('focusout',function(){
                console.log("passando pelo javascript: ");
                var dados = $('#frequenciaConsumo').val();
                //console.log( dados );
                $.ajax({
                  url:'${g.createLink(controller: 'coleta', action: 'consumoAlcool')}',
                  dataType: 'json',
                  data: {frequenciaConsumo: $('#frequenciaConsumo').val(),dosePorVez: $('#dosePorVez').val()}
                  ,
                  success: function (data) {
                    console.log(data);
                    $('#classificacaoEtilismo').val(data);


                  },
                  error: function (request, status, error) {
                    //alert(error);
                  }
                });
              });

              $('#dosePorVez').on('focusout',function(){
                console.log("passando pelo javascript dosePorVez: ");
                var dados = $('#dosePorVez').val();
                //console.log( dados );
                $.ajax({
                  url:'${g.createLink(controller: 'coleta', action: 'consumoAlcool')}',
                  dataType: 'text',
                  data: {frequenciaConsumo: $('#frequenciaConsumo').val(),dosePorVez: $('#dosePorVez').val()}
                  ,
                  success: function (data) {
                    console.log(data);
                    $('#classificacaoEtilismo').val(data);


                  },
                  error: function (request, status, error) {
                    //alert(error);
                  }
                });
              });

        </g:javascript>
    </body>
</html>
