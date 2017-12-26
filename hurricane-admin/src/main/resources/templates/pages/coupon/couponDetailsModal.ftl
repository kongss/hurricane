<!-- 模态框（Modal） -->
<div class="modal fade" id="couponDetailsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="margin-top: 0px;width: 100%;">
        <div class="modal-content" style="height: auto;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    优惠券详情
                </h4>
            </div>
            <div class="modal-body" style="float: left;width: 350px;">
                <input type="hidden" id="DUuid" value=""/>
                <div class="form-group">
                    <label>商城名称：</label>
                    <span id="DSellerUuid">京东商城</span>
                </div>
                <div class="form-group">
                    <label>优惠券名称：</label>
                    <span id="DName">满30-10元</span>
                </div>
                <div class="form-group">
                    <label>优惠券类型：</label>
                    <span id="DType">密码券</span>
                </div>
                <div class="form-group">
                    <label>是否过期：</label>
                    <span id="DIsOverdue">未过期</span>
                </div>
                <div class="form-group">
                    <label>状态：</label>
                    <span id="DStatus">启用</span>
                </div>
                <div class="form-group">
                    <label>是否推荐：</label>
                    <span id="DIsRecom">推荐</span>
                </div>
                <div class="form-group">
                    <label>开始时间：</label>
                    <span id="DStartTime">2017-12-12</span>
                </div>
                <div class="form-group">
                    <label>结束时间：</label>
                    <span id="DEndTime">2018-12-12</span>
                </div>
                <div class="form-group">
                    <label>总数量：</label>
                    <span id="DTotal">100</span>
                </div>
                <div class="form-group">
                    <label>领取：</label>
                    <span id="DReceiveNum">30</span>
                </div>
                <div class="form-group">
                    <label>剩余：</label>
                    <span id="DUnreceiveNum">70</span>
                </div>
                <hr>
                <div class="form-group">
                    <label>导入EXCEL：</label>
                    <input type="file" id="couponData" onchange="uploadExcel('show')"/>
                </div>
                <div>
                    <span>导入预览</span>
                    <textarea id="couponListShow" style="height: 600px;width: 310px;"></textarea>
                    <button onclick="uploadExcel('save')" >确定上传</button>
                </div>
            </div>
            <div class="" style="height: 1500px;margin-left: 350px;border-left: solid 1px #949494;">
                <div style="height: 50px">
                    <h2>兑换码列表&ensp;<button class="btn btn-default" onclick="reloadCouponInstList()">刷新</button></h2>
                </div>
                <div>
                    <div class="table-responsive">
                        <table class="table">
                            <#--<caption>响应式表格布局</caption>-->
                            <thead>
                            <tr>
                                <th>优惠券编号</th>
                                <th>优惠券密码</th>
                                <th>发布时间</th>
                                <th>领取状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="couponInfoList">
                                <tr>
                                    <td>CPSEMXQ0H6R</td>
                                    <td></td>
                                    <td>2017-12-12</td>
                                    <td>未领取</td>
                                    <td><a>删除</a> | <a>下架</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
    function reloadCouponInstList() {
        var DUuid = $("#DUuid").val();
        getCouponInfoList(DUuid);
    }

    function uploadExcel(flag) {
        var formData = new FormData();
        formData.append("file",$("#couponData")[0].files[0]);
        formData.append("flag",flag);
        $.ajax({
            url : 'admin/coupon/analysisExcel',
            type : 'POST',
            data : formData,
            // 告诉jQuery不要去处理发送的数据
            processData : false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType : false,
            //dataType : 'json',
            success : function(data) {
                console.log("data="+data)
                $("#couponListShow").html(data.map.cv);
            },
            error : function(data) {
                console.log("error "+data);
            }
        });
    }
</script>
