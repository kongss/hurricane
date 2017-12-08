<#-- 引入布局指令的命名空间 -->
<#import "../layout/defaultLayout.ftl" as defaultLayout>

<#-- 调用布局指令 -->
<@defaultLayout.layout>
<#-- 将下面这个main content嵌入到layout指令的nested块中 -->
<div style="width:85%; height:600px; float:left; background-color: #ffffff;">
<#--  start  -->
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Bootstrap 实例 - 超大屏幕（Jumbotron）</title>
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

    <div class="container">
        <div class="jumbotron" style="height: 600px">
            <h1>欢迎登陆页面！</h1>
            <p>这是一个超大屏幕（Jumbotron）的实例。</p>
        </div>
    </div>

    </body>
    </html>

<#--  end  -->
</div>
</@defaultLayout.layout>