<#macro layout>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 100%; text-align:center; font-size:30px;">
    <#include "header.ftl">

	    <#include "left.ftl">

	    <#-- 在这里嵌入main content -->
	    <#--<#nested>-->
        <div style="width:85%; height:1000px; float:left; background-color: #ffffff;">
        <iframe id="iframe-content" src="/home" width="100%" height="100%"  frameborder="no" border="0" marginwidth="0"
            marginheight=" 0" scrolling="no" allowtransparency="yes"></iframe>
        </div>
        <#--<#include "footer.ftl">-->
</div>

</body>
</html>
</#macro>