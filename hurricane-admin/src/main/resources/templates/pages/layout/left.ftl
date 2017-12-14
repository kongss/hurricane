<div style="width:15%; height:1000px; float:left; background-color: #e4e4e4;">

    <a href="" style="font-size: 16px;" onclick="menuClick('/')">欢迎页面</a><br>
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

                    <a href="#" onclick="menuClick('/userList')">用户列表</a>
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
                    <a href="#"  onclick="menuClick('/sellerList')">商城列表</a>
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
                    <a href="#" onclick="menuClick('/couponList')">优惠券列表</a>
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
                    <a href="#">用户日点击量</a>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function menuClick(url) {
            $("#iframe-content").attr('src',url);
        }

        $(function () { $('#collapseOne').collapse('show')});
        $(function () { $('#collapseTwo').collapse('show')});
        $(function () { $('#collapseThree').collapse('show')});
        $(function () { $('#collapseFour').collapse('show')});
    </script>


</div>
