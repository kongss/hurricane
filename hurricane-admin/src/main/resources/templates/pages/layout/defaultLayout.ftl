<#macro layout>
<html>
<head>
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