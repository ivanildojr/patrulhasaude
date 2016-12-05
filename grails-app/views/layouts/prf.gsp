<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>   <g:layoutTitle default="PRF"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="https://www.prf.gov.br/design/assets/css/pig.css" rel="stylesheet">
    <!--<link href="http://www.dprf.gov.br/pig/assets/css/docs.css" rel="stylesheet">-->
    <link rel="stylesheet" type="text/css" href="https://www.prf.gov.br/design/assets/css/prf-sistemas-internos.css">
    <link href="/portal/++theme++prf2/css/painel.css" rel="stylesheet" type="text/css">
    <link href="https://www.prf.gov.br/portal/++theme++prf2/css/plone.css" rel="stylesheet">
    <link href="/portal/++theme++prf2/css/jquery-ui-1.10.4.min.css" rel="stylesheet" type="text/css">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
          <script src=
          "http://www.dprf.gov.br/pig/assets/js/html5shiv.js"></script>
        <![endif]-->
    <script async="" src="//www.google-analytics.com/analytics.js"></script><script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/css/painel.css"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/js/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/js/hideMaxListItem-min.js" class="__web-inspector-hide-shortcut__"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/js/site.js"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="/portal/++theme++prf2/js/jquery.Storage.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-44196729-1', 'dprf.gov.br');
        ga('send', 'pageview');

    </script>




    <style id="__web-inspector-hide-shortcut-style__" type="text/css">
    .__web-inspector-hide-shortcut__, .__web-inspector-hide-shortcut__ *, .__web-inspector-hidebefore-shortcut__::before, .__web-inspector-hideafter-shortcut__::after
    {
        visibility: hidden !important;
    }
    </style>

    <g:layoutHead/>
</head>

<body data-spy="scroll"><div class="navbar navbar-inverse">
    <div class="navbar-inner">
        <div zszsclass="container">
            <div class="brand-content"><a class="brand" href="/portal/painel"></a></div>
            <span class="nome-sistema">Patrulha da Saúde - RN</span>
            <div class="login-sistema">
                <div class="btn-group btn-group-user">
                    <a class="btn btn-user dropdown-toggle " data-toggle="dropdown" href="#">
                        <i class="icon-user"></i>
                        <span id="personaltool-menuheader">Nome do usuário <!--Nome do usuário--></span>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu pull-right" id="personaltool-menu">
                        <li id="personaltools-dashboard">
                            <a href="#dashboard">Painel pessoal</a>
                        </li>
                        <li id="personaltools-preferences">
                            <a href="#preferences">Preferências</a>
                        </li>
                        <li id="personaltools-logout">
                            <a href="#logout">Sair</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid" id="main-container">
    <ul class="breadcrumb"><li><!--Breadcrumb--></li></ul>
    <div class="menu-nav">
        <ul class="nav inline">
            <li class="active"> <a href="#modalContato" data-toggle="modal">Fale Conosco</a> </li>
        </ul>
    </div>
    <div class="container-fluid">
        <div id="portal-columns" class="row">

        <div id="conteudo-meio" class="cell width-3:4 position-1:4">

        </div>


        <div id="menu-lateral" class="cell width-1:4 position-0">


        <!--Menu Lateral-->





        </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">

        <ul class="footer-links">
            <li><a href="#">Topo</a></li>
        </ul>
        <p class="inline">NUTEL-RN <small>versão ...</small></p>
    </div>
</footer>
<div id="modalContato" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel"><i class="icon-comments"></i> Envie seus comentários e dúvidas</h3>
    </div>
    <form method="get" action="#" class="forms form-inline" id="frmContato" target="iframeContato">
        <div class="modal-body">
            <input type="hidden" name="url" value="mensagem">
            <label><strong>Informe seu CPF</strong></label>
            <input type="text" placeholder="Digite seu cpf" name="usuarioCpf" class="validate[required]" id="cpf" maxlength="100" value="" data-mask="99999999999">
            <button class="btn btn-primary" type="submit" data-loading-text="Enviando...">Continuar &gt;&gt;</button>
            <iframe style="width:96%; height:250px; border:0;margin-top: 10px; display:none" name="iframeContato" id="iframeContato" src="#" frameborder="0"> </iframe>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
        </div>
    </form>
</div>

</body></html>