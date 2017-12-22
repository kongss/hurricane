<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    优惠券信息
                </h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="uuid" value=""/>
                <div class="form-group">
                    <input type="hidden" id="sellerUuid" value=""/>
                    <label for="sellerUuid">商城名称</label>
                    <select class="form-control" id="seller_selective" onchange="changeSeller(this.value)">
                        <option>请选择</option>
                        <option>京东商城</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="hidden" id="type" value=""/>
                    <label for="type">优惠券类型</label><span style="color: red;">(若选择密码券,请完基本信息添加后在详情页导入兑换码)</span>
                    <select class="form-control" id="couponType" onchange="changeType(this.value)">
                        <option value="0">请选择</option>
                        <option value="1">密码券</option>
                        <option value="2">链接券</option>
                        <option value="3">通用券</option>
                    </select>
                </div>
                <div class="form-group" id="status_div">
                    <input type="hidden" id="status" value=""/>
                    <label for="status">启用状态</label><br/>
                    <input type="radio" onclick="changeStatus(1)" checked name="status"/>启用
                    <input type="radio" onclick="changeStatus(0)" name="status"/>禁用
                </div>
                <div class="form-group" id="isRecom_div">
                    <input type="hidden" id="isRecom" value=""/>
                    <label for="isRecom">是否推荐</label><br/>
                    <input type="radio" onclick="changeIsRecom(1)" checked name="isRecom"/>推荐
                    <input type="radio" onclick="changeIsRecom(2)" name="isRecom"/>不推荐
                </div>
                <div class="form-group">
                    <label for="name">券名称</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="券名称">
                </div>
                <div class="form-group">
                    <label for="derateAmount">减免金额</label>
                    <input type="text" class="form-control" id="derateAmount" name="derateAmount" placeholder="减免金额">
                </div>
                <div class="form-group">
                    <label for="startTime">开始时间</label>
                    <input type="text" class="form-control" id="startTime" name="startTime" placeholder="开始时间">
                </div>
                <div class="form-group">
                    <label for="endTime">结束时间</label>
                    <input type="text" class="form-control" id="endTime" name="endTime" placeholder="结束时间">
                </div>
                <div class="form-group">
                    <label for="activityLinkUrl">链接URL</label>
                    <input type="text" class="form-control" id="activityLinkUrl" name="activityLinkUrl" placeholder="链接URL">
                </div>
                <div class="form-group">
                    <label for="useExplain">使用说明</label>
                    <input type="text" class="form-control" id="useExplain" name="useExplain" placeholder="使用说明">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="editCoupon()">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">
    function editCoupon() {
        var sellerUuid = $("#sellerUuid").val();
        var uuid = $("#uuid").val();
        var name = $("#name").val();
        var type = $("#type").val();
        var status = $("#status").val();
        var isRecom = $("#isRecom").val();
        var derateAmount = $("#derateAmount").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var activityLinkUrl = $("#activityLinkUrl").val();
        var useExplain = $("#useExplain").val();
        //发生ajax保存数据
        $.ajax({
            type: 'POST',
            url: "/admin/coupon/editCoupon",
            data: {"uuid": uuid, "name": name, "derateAmount": derateAmount, "derateAmount": derateAmount,
                "sellerUuid": sellerUuid, "type": type, "status": status, "isRecom": isRecom,
                "startTime": startTime, "endTime": endTime, "activityLinkUrl": activityLinkUrl, "useExplain": useExplain},
            //dataType: "json",
            success: function(data){
                console.log(data);
                if ("0000" != data.resCode){
                    alert("操作异常！！！联系管理员");
                    return false;
                }
                alert("操作成功！！");
                window.location.reload();
            }
        });
    }

    function changeSeller(thisObj) {
        console.log(thisObj);
        $("#sellerUuid").val(thisObj);
    }
    function changeType(thisObj) {
        console.log(thisObj);
        $("#type").val(thisObj);
    }
    function changeStatus(val) {
        $("#status").val(val)
    }
    function changeIsRecom(val) {
        $("#isRecom").val(val)
    }
</script>
