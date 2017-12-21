$(function () {
    couponList(1,10);
    //绑定模态框展示的方法
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);// 触发事件的按钮
        var uuid = button.context.dataset.id;
        var name = button.context.innerHTML;
        $("#myModalLabel").html(name+'商城信息');
        if (uuid != null && uuid != '' && uuid != 'null'){
            toEditCouponPageShow(uuid);
        }
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
        }
    });
}

function couponList(currentPage,pageSize,couponList) {
    //console.log("currentPage="+currentPage+" pageSize="+pageSize);
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
                    htmlStr+='<td>'+checkEmpty(value.seller_uuid)+'</td>';
                    htmlStr+='<td>来源</td>';
                    htmlStr+='<td>'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.derate_amount)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.start_time)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.end_time)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.activity_link_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.type)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.is_overdue)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.is_recom)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.total)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.receive_num)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.unreceive_num)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<td><button class="btn btn-default" data-toggle="modal">详情</button><button class="btn btn-default" data-id="'+value.uuid+'" data-toggle="modal" data-target="#myModal">修改</button></td>';
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