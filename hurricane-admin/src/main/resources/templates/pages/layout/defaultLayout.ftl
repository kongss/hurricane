<#macro layout>
<html>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 100%; text-align:center; font-size:30px;">
    <#include "header.ftl">

	    <#include "left.ftl">

	    <#-- 在这里嵌入main content -->
	    <#nested>

	    <#--<#include "footer.ftl">-->
</div>
</body>
</html>
</#macro>