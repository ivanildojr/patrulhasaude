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
</head>
<body>
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
