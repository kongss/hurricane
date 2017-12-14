<#-- 引入布局指令的命名空间 -->
<#import "../layout/defaultLayout.ftl" as defaultLayout>

<#-- 调用布局指令 -->
<@defaultLayout.layout>
<#-- 将下面这个main content嵌入到layout指令的nested块中 -->
<div style="width:85%; height:1000px; float:left; background-color: #ffffff;">
<#--  start  -->


<#--  end  -->
</div>
</@defaultLayout.layout>