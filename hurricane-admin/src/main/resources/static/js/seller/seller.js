$(function () {
    sellerList();
});

function sellerList() {
    $.ajax({
        type: "POST",
        async: "true",
        url: "/admin/seller/sellerList",
        timeout: 6000,
        data: {},
        //dataType: "json",
        success:function (data) {
            if ("0000" != data.resCode){
                alert("查询失败！！！连管理员");
                return false;
            }
            var object = data.map.sellerList;
            if (object.length >0){
                var htmlStr = '';
                $.each(object, function(name, value) {
                    console.log("value "+value)
                    htmlStr+='<tr>';
                    htmlStr+='<td>'+checkEmpty(value.name)+'</td>';
                    htmlStr+='<td><img style="height: 60px;" src="'+checkEmpty(value.logo_pic_url)+'"></td>';
                    htmlStr+='<td>'+checkEmpty(value.site_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.source)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.status)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.short_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.long_url)+'</td>';
                    htmlStr+='<td>'+checkEmpty(value.create_time)+'</td>';
                    htmlStr+='<tr>';
                });
                $("#sellerList").html(htmlStr);
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