$(function () {
    couponList(1,10);
    //绑定模态框展示的方法
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        //var name = button.context.innerHTML;
        //$("#myModalLabel").html(name+'优惠券信息');
        //根据uuid判断是否修改操作，查询
        if (uuid != null && uuid != '' && uuid != 'null'){
            toEditCouponPageShow(uuid);
        }else {
            //添加时，清除文本框残留的数值
            cleanValue();
        }
    });

    //详情页模态框展示
    $('#couponDetailsModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        //var name = button.context.innerHTML;
        //console.log("------------uuid------------"+uuid);
        //查询优惠券详情
        getCoupon(uuid);
        //查询优惠券兑换码列表
        getCouponInfoList(uuid);
    });
});

function getCoupon(uuid) {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/getCoupon",
        timeout: 6000,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询商城信息失败！！！连管理员");
                return false;
            }
            var coupon= data.map.coupon;
            var seller= data.map.seller;
            $("#DUuid").val(coupon.uuid);
            $("#DSellerUuid").html(seller.name);
            $("#DName").html(coupon.name);
            var typeStr = coupon.type = 0 ? "密码券" : coupon.type = 1 ? "链接券" : coupon.type = 2 ? "通用券" : "异常状态";
            $("#DType").html(typeStr);
            var isOverdueStr = coupon.isOverdue = 0 ? "已过期" : coupon.isOverdue = 1 ? "未过期" :"异常状态";
            $("#DIsOverdue").html(isOverdueStr);
            var statusStr = coupon.status = 0 ? "禁用" : coupon.status = 1 ? "启用" :"异常状态";
            $("#DStatus").html(statusStr);
            var isRecomStr = coupon.isRecom = 0 ? "不推荐" : coupon.isRecom = 1 ? "推荐" :"异常状态";
            $("#DIsRecom").html(isRecomStr);
            $("#DStartTime").html(coupon.startTime);
            $("#DEndTime").html(coupon.endTime);
            $("#DTotal").html(coupon.total);
            $("#DReceiveNum").html(coupon.receiveNum);
            $("#DUnreceiveNum").html(coupon.unreceiveNum);

        }
    });
}

function getCouponInfoList(uuid) {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/getCouponInfoList",
        timeout: 6000,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询商城信息失败！！！连管理员");
                return false;
            }
            var htmlStr = '';
            var ci = data.map.list;
            for (var i=0;i<ci.length;i++){
                var number = (ci[i].number == null || ci[i].number == '' || ci[i].number == undefined) ? "" : ci[i].number;
                var code = (ci[i].code == null || ci[i].code == '' || ci[i].code == undefined) ? "" : ci[i].code;
                var status = (ci[i].status == null || ci[i].status == '' || ci[i].status == undefined) ? "" : ci[i].status == 1 ? "未领取" : ci[i].status == 2 ? "已领取" : ci[i].status == 3 ? "已过期" : "异常状态";
                htmlStr+='<tr>';
                htmlStr+='<td>'+number+'</td>';
                htmlStr+='<td>'+code+'</td>';
                htmlStr+='<td>'+status+'</td>';
                htmlStr+='<td><a style="cursor: pointer" onclick="deleteCouponInfo(\''+ci[i].uuid+'\')">删除</a></td>';
                htmlStr+='</tr>';
            }
            $("#couponInfoList").html(htmlStr);

        }
    });
}

function deleteCouponInfo(uuid) {
    console.log("uuid==================="+uuid);
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/deleteCoupon",
        timeout: 6000,
        async:false,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("删除失败！！！连管理员");
                return false;
            }
            alert("删除成功！！");
        }
    });
    reloadCouponInstList();
}

function cleanValue() {
    $("#sellerUuid").val("");
    $("#uuid").val("");
    $("#name").val("");
    $("#type").val("");
    $("#status").val("");
    $("#isRecom").val("");
    $("#derateAmount").val("");
    $("#startTime").val("");
    $("#endTime").val("");
    $("#activityLinkUrl").val("");
    $("#useExplain").val("");
    initCouponStatus(-1);
    initCouponIsRecom(-1);
    initCouponType(-1);
    //加载商城下拉菜单,默认0 没有传值
    initSellerSelective(0)
}
function toEditCouponPageShow(uuid) {
    //console.log("uuid>>>>>>>>>>>>>>>>>>>>>>>>>"+uuid);
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/getCoupon",
        timeout: 6000,
        data: {"uuid":uuid},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询商城信息失败失败！！！连管理员");
                return false;
            }
            var cou = data.map.coupon;
            $("#uuid").val(cou.uuid);
            $("#name").val(cou.name);
            $("#type").val(cou.type);
            $("#status").val(cou.status);
            $("#isRecom").val(cou.isRecom);
            $("#derateAmount").val(cou.derateAmount);
            $("#startTime").val(cou.startTime);
            $("#endTime").val(cou.endTime);
            $("#activityLinkUrl").val(cou.activityLinkUrl);
            $("#sellerUuid").val(cou.sellerUuid);
            $("#useExplain").val(cou.useExplain);
            //加载优惠券类型菜单
            initCouponType(cou.type);
            //加载优惠券回显状态
            initCouponStatus(cou.status);
            //加载优惠券是否推荐
            initCouponIsRecom(cou.isRecom);
            //加载商城下拉菜单
            initSellerSelective(cou.sellerUuid);
        }
    });
}
function initCouponStatus(status){
    var htmlStr = '';
    htmlStr+='<input type="hidden" id="status" value="1"/>';
    htmlStr+='<label for="status">启用状态</label><br/>';
    if(status == 1){//启用
        htmlStr+='<input type="radio" onclick="changeStatus(1)" checked name="status"/>启用';
        htmlStr+='<input type="radio" onclick="changeStatus(0)" name="status"/>禁用';
    }
    if(status == 0){
        htmlStr+='<input type="radio" onclick="changeStatus(1)" name="status"/>启用';
        htmlStr+='<input type="radio" onclick="changeStatus(0)" checked name="status"/>禁用';
    }
    if(status == -1){
        htmlStr+='<input type="radio" checked onclick="changeStatus(1)" name="status"/>启用';
        htmlStr+='<input type="radio" onclick="changeStatus(0)" name="status"/>禁用';
    }
    $("#status_div").html(htmlStr);

}
function initCouponIsRecom(isRecom) {
    var htmlStr = '';
    htmlStr+='<input type="hidden" id="isRecom" value="1"/>';
    htmlStr+='<label for="isRecom">是否推荐</label><br/>';

    if(isRecom == 1){
        htmlStr+='<input type="radio" onclick="changeIsRecom(1)" checked name="isRecom"/>推荐';
        htmlStr+='<input type="radio" onclick="changeIsRecom(2)" name="isRecom"/>不推荐';
    }
    if(isRecom == 2){
        htmlStr+='<input type="radio" onclick="changeIsRecom(1)" name="isRecom"/>推荐';
        htmlStr+='<input type="radio" onclick="changeIsRecom(2)" checked name="isRecom"/>不推荐';
    }
    if(isRecom == -1){
        htmlStr+='<input type="radio" onclick="changeIsRecom(1)" checked name="isRecom"/>推荐';
        htmlStr+='<input type="radio" onclick="changeIsRecom(2)" name="isRecom"/>不推荐';
    }
    $("#isRecom_div").html(htmlStr);
}
function initCouponType(type) {
    var htmlStr = '';
    htmlStr+='<option value="0">请选择</option>';
    if (type == 1){
        htmlStr+='<option selected value="1">密码券</option>';
        htmlStr+='<option value="2">链接券</option>';
        htmlStr+='<option value="3">通用券</option>';
    }
    if (type == 2){
        htmlStr+='<option value="1">密码券</option>';
        htmlStr+='<option selected value="2">链接券</option>';
        htmlStr+='<option value="3">通用券</option>';
    }
    if (type == 3){
        htmlStr+='<option value="1">密码券</option>';
        htmlStr+='<option value="2">链接券</option>';
        htmlStr+='<option selected value="3">通用券</option>';
    }
    if (type == -1){
        htmlStr+='<option value="1">密码券</option>';
        htmlStr+='<option value="2">链接券</option>';
        htmlStr+='<option value="3">通用券</option>';
    }
    $("#couponType").html(htmlStr);

}
function initSellerSelective(sellerUuid) {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/sellerList",
        timeout: 6000,
        data: {},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询商城信息失败！！！连管理员");
                return false;
            }
            var sel = data.map.list;
            var htmlStr = '';
            htmlStr+='<option>请选择</option>';
            $.each(sel, function(name, value) {
                //console.log(value.name);
                if (sellerUuid == value.uuid){
                    htmlStr+='<option selected value="'+value.uuid+'">'+value.name+'</option>';
                }else {
                    htmlStr+='<option value="'+value.uuid+'">'+value.name+'</option>';
                }
            });
            $("#seller_selective").html(htmlStr);
        }
    });
}

function couponList(currentPage,pageSize) {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/couponList",
        timeout: 6000,
        data: {"currentPage":currentPage,"pageSize":pageSize},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询失败！！！连管理员");
                return false;
            }
            var object = data.map.list;
            if (object.length >0){
                var htmlStr = '';
                $.each(object, function(name, value) {
                    htmlStr+='<tr>';
                    /*htmlStr+='<td><input type="checkbox"/></td>';*/
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.sName)+'</tds>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.sSource)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.derate_amount)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.start_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.end_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.activity_link_url)+'</td>';
                    var typeStr = value.type == 1 ? "密码券" : value.type == 2 ? "链接券" : value.type == 3 ? "通用" : "";
                    htmlStr+='<td style="white-space: nowrap;">'+typeStr+'</td>';
                    var statusStr = value.status == 0 ? "禁用" : "启用";
                    htmlStr+='<td style="white-space: nowrap;">'+statusStr+'</td>';
                    var isOverdueStr = value.is_overdue == 0 ? "已过期" : "未过期";
                    htmlStr+='<td style="white-space: nowrap;">'+isOverdueStr+'</td>';
                    var isRecomStr = value.is_recom == 0 ? "不推荐" : "推荐";
                    htmlStr+='<td style="white-space: nowrap;">'+isRecomStr+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.total)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.receive_num)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.unreceive_num)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;"><button class="btn btn-default" data-id="'+value.uuid+'" data-toggle="modal" data-target="#couponDetailsModal">详情</button><button class="btn btn-default" data-id="'+value.uuid+'" data-toggle="modal" data-target="#myModal">修改</button></td>';
                    htmlStr+='<tr>';
                });
                $("#couponList").html(htmlStr);
                //分页
                page(data);

            }
        }
    });
}

function checkEmpty(param) {
    if (param == null || param == '' || param == 'undefined'){
        return '';
    }
    return param;
}