$(function () {
    couponList(1,10);
    //绑定模态框展示的方法
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        var name = button.context.innerHTML;
        $("#myModalLabel").html(name+'商城信息');
        //根据uuid判断是否修改操作，查询
        if (uuid != null && uuid != '' && uuid != 'null'){
            toEditCouponPageShow(uuid);
        }
        //加载商城下拉菜单,默认0 没有传值
        initSellerSelective(0)
    });
});

function toEditCouponPageShow(uuid) {
    console.log("uuid>>>>>>>>>>>>>>>>>>>>>>>>>"+uuid);
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
            $("#derateAmount").val(cou.derateAmount);
            $("#startTime").val(cou.startTime);
            $("#endTime").val(cou.endTime);
            $("#activityLinkUrl").val(cou.activityLinkUrl);
            $("#activityLinkUrl").val(cou.sellerUuid);
            //加载商城下拉菜单
            initSellerSelective(cou.sellerUuid);
        }
    });
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
                htmlStr+='<option value="'+value.uuid+'">'+value.name+'</option>';
            });
            $("#seller_selective").html(htmlStr);
        }
    });
}

function couponList(currentPage,pageSize,couponList) {
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
                    htmlStr+='<td><input type="checkbox"/></td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.sName)+'</tds>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.sSource)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.derate_amount)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.start_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.end_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.activity_link_url)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.type)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.is_overdue)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.is_recom)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.total)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.receive_num)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.unreceive_num)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;">'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td style="white-space: nowrap;"><button class="btn btn-default" data-toggle="modal">详情</button><button class="btn btn-default" data-id="'+value.uuid+'" data-toggle="modal" data-target="#myModal">修改</button></td>';
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