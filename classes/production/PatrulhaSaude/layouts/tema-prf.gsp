<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>    <g:layoutTitle default="Grails"/></title>
    <g:layoutHead/>
    <asset:stylesheet src="css/bootstrap.min.css" />

    <asset:stylesheet src="font-awesome/css/font-awesome.min.css" />

    <asset:stylesheet src="all.min.css" />

    <asset:stylesheet src="theme.css" />
    <asset:stylesheet src="dashboard.css" />
    <asset:stylesheet src="prf-sistemas-internos.css" />
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top container" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html" title="PB Dashboard">PB Dashboard</a>
    </div>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <li class="active"><a href="index.html"><i class="glyphicon glyphicon-th"></i> Dashboard</a></li>
            <li class="nav nav-list nav-list-expandable nav-list-expanded">
                <a><i class="fa fa-user"></i> More Widgets <span class="caret"></span></a>
                <ul class="nav navbar-nav">
                    <li><a href="../../../../../../Users/Ivanildo%20JR/Downloads/Theme-PBDashboard/Theme-PBDashboard/datagrid.html"><i class="fa fa-table"></i> Data Grid</a></li>
                    <li><a href="../../../../../../Users/Ivanildo%20JR/Downloads/Theme-PBDashboard/Theme-PBDashboard/editor.html"><i class="fa fa-edit"></i> Editor</a></li>
                </ul>
            </li>
            <li><a href="../../../../../../Users/Ivanildo%20JR/Downloads/Theme-PBDashboard/Theme-PBDashboard/bootstrap.html"><i class="fa fa-magic"></i> Bootstrap Elements</a></li>
            <li class="nav nav-list nav-list-expandable">
                <a><i class="fa fa-key"></i> Collapsed Menu Item <span class="caret"></span></a>
                <ul class="nav navbar-nav">
                    <li><a href="#">Sub Item 1</a></li>
                    <li><a href="#">Sub Item 2</a></li>
                </ul>
            <li>
        </ul>
        <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown messages-dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Messages <span class="label label-danger">2</span> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">2 New Messages</li>
                    <li class="message-preview">
                        <a href="#">
                            <span class="avatar"><i class="fa fa-bell"></i></span>
                            <span class="message">Security alert</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li class="message-preview">
                        <a href="#">
                            <span class="avatar"><i class="fa fa-bell"></i></span>
                            <span class="message">Security alert</span>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#">Go to Inbox <span class="badge">2</span></a></li>
                </ul>
            </li>
            <li class="dropdown user-dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Steve Miller<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                    <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<g:layoutBody/>

<asset:javascript src="tema.js"/>
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        $("#grid").shieldGrid({
            dataSource: {
                data: <g:applyCodec encodeAs="none">${gridData}</g:applyCodec>
            },
            sorting:{
                multiple: true
            },
            paging: {
                pageSize: 12,
                pageLinksCount: 10
            },
            selection:{
                type: "row",
                multiple: true,
                toggle: false
            },
            columns: [
                { field: "id", width: "70px", title: "ID" },
                { field: "name", title: "Person Name" },
                { field: "company", title: "Company Name" },
                { field: "email", title:"Email Address", width: "270px" }
            ]
        });
    });
</script>

</body>
</html>
