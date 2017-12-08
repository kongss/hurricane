<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="width:15%; height:600px; float:left; background-color: #e4e4e4;">

    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Bootstrap 实例 - 折叠（Collapse）插件方法</title>
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

    <div class="panel-group" id="accordion" style="font-size: 15px">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        用户管理
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="http://localhost:8080/userList">用户列表</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default" style="margin-top: 0px;">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo">
                        商城管理
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="#">商城列表</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default" style="margin-top: 0px;">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree">
                        优惠券管理
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="#">优惠券列表</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default" style="margin-top: 0px;">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseFour">
                        统计管理
                    </a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse">
                <div class="panel-body">
                    <a href="http://localhost:8080/">欢迎页面</a><br>
                    <a href="#">用户日点击量</a>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () { $('#collapseFour').collapse({
            toggle: false
        })});
        $(function () { $('#collapseTwo').collapse('toggle')});
        $(function () { $('#collapseThree').collapse('hide')});
        $(function () { $('#collapseOne').collapse('hide')});
    </script>

    </body>
    </html>

</div>
</body>
</html>