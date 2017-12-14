$(function () {
    couponList();
});

function couponList() {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/coupon/couponList",
        timeout: 6000,
        data: {},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询失败！！！连管理员");
                return false;
            }
            var object = data.map.couponList;
            if (object.length >0){
                var htmlStr = '';
                $.each(object, function(name, value) {
                    console.log("value "+value)
                    htmlStr+='<tr>';
                    htmlStr+='<td>'+checkEmpty(value.seller_uuid)+'</td>';
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
                    htmlStr+='<td><a href="">详情</a></td>';
                    htmlStr+='<tr>';
                });
                $("#couponList").html(htmlStr);
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