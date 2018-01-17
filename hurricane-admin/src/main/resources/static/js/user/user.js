$(function () {
    couponList(1,10);
});

function couponList(currentPage,pageSize) {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/user/userList",
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
                    htmlStr+='<td>'+checkEmpty(value.nickname)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.gender)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.province)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.city)+'</td>';
                    htmlStr+='<tr>';
                });
                $("#userList").html(htmlStr);
                //分页
                page(data);
            }else{
                $("#userList").html('');
                $(".pagination").html('');
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